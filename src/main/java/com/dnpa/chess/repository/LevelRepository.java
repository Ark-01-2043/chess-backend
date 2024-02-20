package com.dnpa.chess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnpa.chess.entity.Level;
import java.util.List;
import com.dnpa.chess.entity.Algorithm;


public interface LevelRepository extends JpaRepository<Level, Integer>{
	List<Level> findByAlgorithm(Algorithm algorithm);
}
