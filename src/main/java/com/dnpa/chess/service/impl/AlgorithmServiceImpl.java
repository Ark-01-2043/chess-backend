package com.dnpa.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnpa.chess.entity.Algorithm;
import com.dnpa.chess.repository.AlgorithmRepository;
import com.dnpa.chess.service.AlgorithmService;

@Service
public class AlgorithmServiceImpl implements AlgorithmService{
	
	@Autowired
	private AlgorithmRepository algorithmRepository;
	@Override
	public void saveAlgorithm(Algorithm algorithm) {
		// TODO Auto-generated method stub
		algorithmRepository.save(algorithm);
	}

	@Override
	public List<Algorithm> getAllAlgorithms() {
		// TODO Auto-generated method stub
		return algorithmRepository.findAll();
	}

	@Override
	public void updateAlgorithm(Algorithm algorithm) {
		// TODO Auto-generated method stub
		algorithmRepository.save(algorithm);
	}

	@Override
	public void deleteAlgorithm(int id) {
		// TODO Auto-generated method stub
		algorithmRepository.deleteById(id);
	}

	@Override
	public Algorithm getAlgorithmById(int id) {
		// TODO Auto-generated method stub
		return algorithmRepository.findById(id).get();
	}

}
