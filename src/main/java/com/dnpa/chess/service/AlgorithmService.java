package com.dnpa.chess.service;

import java.util.List;

import com.dnpa.chess.entity.Algorithm;

public interface AlgorithmService {
	public void saveAlgorithm(Algorithm algorithm);
	public List<Algorithm> getAllAlgorithms();
	public void updateAlgorithm(Algorithm algorithm);
	public void deleteAlgorithm(int id);
	public Algorithm getAlgorithmById(int id);
}
