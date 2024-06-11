package com.dnpa.chess.dto;

import lombok.Builder;
import lombok.Data;

//@Data
//@Builder
public class ThongKeCheDo {
	private int levelId;
	private int win;
	private int draw;
	private int lose;
	public int getLevelId() {
		return levelId;
	}
	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public ThongKeCheDo(int levelId, int win, int draw, int lose) {
		super();
		this.levelId = levelId;
		this.win = win;
		this.draw = draw;
		this.lose = lose;
	}
	public ThongKeCheDo() {
		super();
	}
	
}
