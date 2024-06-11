package com.dnpa.chess.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//@Data
//@Builder
@Entity
//@NoArgsConstructor
//@AllArgsConstructor
public class Game {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getGameDate() {
		return gameDate;
	}
	public void setGameDate(LocalDateTime gameDate) {
		this.gameDate = gameDate;
	}
	public String getPlayerSide() {
		return playerSide;
	}
	public void setPlayerSide(String playerSide) {
		this.playerSide = playerSide;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getResultInt() {
		return resultInt;
	}
	public void setResultInt(int resultInt) {
		this.resultInt = resultInt;
	}
	public String getMove() {
		return move;
	}
	public void setMove(String move) {
		this.move = move;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime gameDate;
	private String playerSide;
	private String winner;
	private String result;
	private int resultInt;
	@Column(length = 1500)
	private String move;
	@ManyToOne(targetEntity = Level.class)
	private Level level;
	@ManyToOne(targetEntity = User.class)
	private User user;
	public Game(Integer id, LocalDateTime gameDate, String playerSide, String winner, String result, int resultInt,
			String move, Level level, User user) {
		super();
		this.id = id;
		this.gameDate = gameDate;
		this.playerSide = playerSide;
		this.winner = winner;
		this.result = result;
		this.resultInt = resultInt;
		this.move = move;
		this.level = level;
		this.user = user;
	}
	public Game() {
		super();
	}
	
	
	
}
