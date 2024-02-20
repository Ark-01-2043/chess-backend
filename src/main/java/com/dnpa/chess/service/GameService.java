package com.dnpa.chess.service;

import java.io.IOException;
import java.util.List;

import com.dnpa.chess.dto.GameDto;
import com.dnpa.chess.dto.RankingDto;
import com.dnpa.chess.entity.Game;

public interface GameService {
	public List<Game> getAllGameOfUser(int user_id);
	public Game saveGame(GameDto gameDto);
	public List<Game> getAllGames();
	public List<RankingDto> getRanking();
	public String generateNextMove(GameDto gameDto) throws IOException, InterruptedException;
}
