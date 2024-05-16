package com.dnpa.chess.service;

import java.util.List;

import com.dnpa.chess.entity.Level;

public interface LevelService {
	public List<Level> getAllLevels();
	public Level saveLevel(Level level);
	public Level getLevelById(int id);
	public Level getLevelByAlgorithm(int levelId);
}
