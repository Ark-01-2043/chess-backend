package com.dnpa.chess.dto;

import java.time.LocalDateTime;

import javax.persistence.ManyToOne;

import com.dnpa.chess.entity.Level;
import com.dnpa.chess.entity.User;

import lombok.Data;

//@Data
public class GameDto {
	
	private int id;
	private String playerSide;
	private String result;
	private String winner;
	private String move;
	private String fen;
	private int levelId;
	
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerSide() {
		return playerSide;
	}

	public void setPlayerSide(String playerSide) {
		this.playerSide = playerSide;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getMove() {
		return move;
	}

	public void setMove(String move) {
		this.move = move;
	}

	public String getFen() {
		return fen;
	}

	public void setFen(String fen) {
		this.fen = fen;
	}

	public int getLevelId() {
		return levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public GameDto(int id, String playerSide, String result, String winner, String move, String fen, int levelId,
			int userId) {
		super();
		this.id = id;
		this.playerSide = playerSide;
		this.result = result;
		this.winner = winner;
		this.move = move;
		this.fen = fen;
		this.levelId = levelId;
		this.userId = userId;
	}

	public GameDto() {
		super();
	}
	
}
