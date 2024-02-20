package com.dnpa.chess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnpa.chess.entity.Algorithm;

public interface AlgorithmRepository extends JpaRepository<Algorithm, Integer>{

}
