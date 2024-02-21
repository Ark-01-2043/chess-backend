package com.dnpa.chess.dto;

import java.util.List;

import com.dnpa.chess.entity.Game;
import com.dnpa.chess.entity.User;

import lombok.Data;
//@Data
public class RankingDto {
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	private User user;
	private List<Game> games;
	private int score;
	private int rank;
	
}
