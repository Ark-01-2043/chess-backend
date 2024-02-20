package com.dnpa.chess.dto;

import java.util.List;

import com.dnpa.chess.entity.Game;
import com.dnpa.chess.entity.User;

import lombok.Data;
@Data
public class RankingDto {
	private User user;
	private List<Game> games;
	private int score;
	private int rank;
}
