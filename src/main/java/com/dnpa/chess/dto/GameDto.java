package com.dnpa.chess.dto;

import java.time.LocalDateTime;

import javax.persistence.ManyToOne;

import com.dnpa.chess.entity.Level;
import com.dnpa.chess.entity.User;

import lombok.Data;

@Data
public class GameDto {
	
	private int id;
	private String playerSide;
	private String result;
	private String winner;
	private String move;
	private String fen;
	private int levelId;
	
	private int userId;
}
