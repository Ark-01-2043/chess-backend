package com.dnpa.chess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnpa.chess.entity.Game;
import com.dnpa.chess.entity.User;

public interface GameRepository extends JpaRepository<Game, Integer> {
	List<Game> findByUser(User user);
}