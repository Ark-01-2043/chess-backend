package com.dnpa.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnpa.chess.entity.Level;
import com.dnpa.chess.repository.AlgorithmRepository;
import com.dnpa.chess.repository.LevelRepository;
import com.dnpa.chess.service.LevelService;

@Service
public class LevelServiceImpl implements LevelService{
	@Autowired
	private LevelRepository levelRepository;
	@Autowired
	private AlgorithmRepository algorithmRepository;
	@Override
	public List<Level> getAllLevels() {
		// TODO Auto-generated method stub
		return levelRepository.findAll();
	}

	@Override
	public void saveLevel(Level level) {
		// TODO Auto-generated method stub
		levelRepository.save(level);
	}

	@Override
	public Level getLevelById(int id) {
		// TODO Auto-generated method stub
		return levelRepository.findById(id).get();
	}

	@Override
	public Level getLevelByAlgorithm(int levelId) {
		// TODO Auto-generated method stub
		List<Level> levels = levelRepository.findByAlgorithm(algorithmRepository.findById(levelId).get());
		return (levels.size() == 0)? null: levels.get(0);
	}
	
}
