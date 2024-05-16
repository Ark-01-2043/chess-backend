package com.dnpa.chess.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.aspectj.bridge.context.CompilationAndWeavingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnpa.chess.entity.Algorithm;
import com.dnpa.chess.dto.GameDto;
import com.dnpa.chess.dto.OverallDetail;
import com.dnpa.chess.dto.RankingDto;
import com.dnpa.chess.dto.ThongKeCheDo;
import com.dnpa.chess.entity.Game;
import com.dnpa.chess.entity.Level;
import com.dnpa.chess.entity.User;
import com.dnpa.chess.mapper.UserMapper;
import com.dnpa.chess.repository.GameRepository;
import com.dnpa.chess.repository.LevelRepository;
import com.dnpa.chess.repository.UserRepo;
import com.dnpa.chess.security.JwtTokenProvider;
import com.dnpa.chess.service.GameService;
@Service
public class GameServiceImpl implements GameService{
	@Autowired
	private GameRepository gameRepository;
	@Autowired 
	private UserRepo userRepo;
	@Autowired
	private LevelRepository levelRepository;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Override
	public List<Game> getAllGameOfUser(int user_id) {
		// TODO Auto-generated method stub
		return gameRepository.findByUser(userRepo.findById(user_id).get());
	}

	@Override
	public Game saveGame(GameDto gameDto) {
		// TODO Auto-generated method stub
		Game game = userMapper.map(gameDto);
		game.setLevel(levelRepository.findById(gameDto.getLevelId()).get());
		game.setUser(userRepo.findById(gameDto.getUserId()).get());
		game.setGameDate(LocalDateTime.now());
		if (gameDto.getWinner() == "0") {
			game.setResultInt(0);
		} else {
			if (gameDto.getWinner().equals(gameDto.getPlayerSide())) {
				game.setResultInt(1);
			} else {
				game.setResultInt(-1);
			}
		}
		gameRepository.save(game);
		return game;
	}

	@Override
	public List<Game> getAllGames() {
		// TODO Auto-generated method stub
		return gameRepository.findAll();
	}

	@Override
	public List<RankingDto> getRanking() {
		// TODO Auto-generated method stub
		List<RankingDto> rankingDtos = new ArrayList<RankingDto>();
		List<User> users = userRepo.findAll();
		for (User user : users) {
			List<Game> games = gameRepository.findByUser(user);
			RankingDto rankingDto = new RankingDto();
			rankingDto.setUser(user);
			rankingDto.setGames(games);
			int score = 0;
			for (Game game : games) {
				if (game.getWinner().equals(game.getPlayerSide())) {
					score += game.getLevel().getId();
				}
				else if (!game.getWinner().equals("0")) {
					score -= game.getLevel().getId();
				}
			}
			rankingDto.setScore(score);
		}
		rankingDtos.sort(new Comparator<RankingDto>() {

			@Override
			public int compare(RankingDto o1, RankingDto o2) {
				// TODO Auto-generated method stub
				if (o1.getScore() != o2.getScore()) {
					return o2.getScore() - o1.getScore();
				}
				return o1.getGames().size() - o2.getGames().size();
			}
		});
		int currentRank = 1;
        int countSameRank = 1;

        for (int i = 0; i < rankingDtos.size(); i++) {
            RankingDto rankingDto = rankingDtos.get(i);

            if (i > 0) {
                RankingDto prevUser = rankingDtos.get(i - 1);

                if (rankingDto.getScore() == prevUser.getScore() &&
                        rankingDto.getGames().size() == prevUser.getGames().size()) {
                    
                    rankingDto.setRank(prevUser.getRank());
                    countSameRank++;
                } else {
                    
                    rankingDto.setRank(currentRank);
                    currentRank += countSameRank;
                    countSameRank = 1;
                }
            } else {
                
                rankingDto.setRank(currentRank);
            }
        }
		return rankingDtos;
	}

	@Override
	public String generateNextMove(GameDto gameDto) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
			Level level = levelRepository.findById(gameDto.getLevelId()).get();
			
			Algorithm algorithm = level.getAlgorithm();
			String exePath = algorithm.getPath();
	        int depth = level.getDepth();
	        System.out.println("ai");
	        
	        return getNextMove(gameDto.getFen(), depth, exePath);
		
	}
	private String getNextMove(String fen, int depth, String exePath) throws IOException, InterruptedException {
		String[] command = {exePath, fen, "" + depth};
        Process process;
		process = Runtime.getRuntime().exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        
        String line;
        List<String> matrix	= new ArrayList<>();
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            matrix.add(line);
        }
        int exitCode = process.waitFor();
        System.out.println("Exit code: " + exitCode);
        reader.close();
        return matrix.get(0);
	}
	@Override
	public List<Game> getHistory(String token){
		User user = userRepo.findByUsername(jwtTokenProvider.getUserNameFromJwtToken(token)).get(0);
		return gameRepository.findByUser(user);
	}
	@Override
	public OverallDetail getOverallDetails(String token) {
		User user = userRepo.findByUsername(jwtTokenProvider.getUserNameFromJwtToken(token)).get(0);
		List<Game> games = gameRepository.findByUser(user);
		List<ThongKeCheDo> list = new ArrayList<ThongKeCheDo>();
		list.add(ThongKeCheDo.builder().levelId(1).win(0).draw(0).lose(0).build());
		list.add(ThongKeCheDo.builder().levelId(2).win(0).draw(0).lose(0).build());
		list.add(ThongKeCheDo.builder().levelId(3).win(0).draw(0).lose(0).build());
		games.stream().forEach((game) -> {
			int win = list.get(game.getLevel().getId() - 1).getWin();
			int draw = list.get(game.getLevel().getId() - 1).getDraw();
			int lose = list.get(game.getLevel().getId() - 1).getLose();
			if (game.getResultInt() == 1) {
				list.get(game.getLevel().getId() - 1).setWin(win + 1);
			} else if (game.getResultInt() == -1) {
				list.get(game.getLevel().getId() - 1).setLose(lose + 1);
			} else {
				list.get(game.getLevel().getId() - 1).setDraw(draw + 1);
			}
		});
		return OverallDetail.builder().user(user)
									.thongke(list).build();
									
	}
}
