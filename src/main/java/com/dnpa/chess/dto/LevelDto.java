package com.dnpa.chess.dto;

import javax.persistence.ManyToOne;

import com.dnpa.chess.entity.Algorithm;

import lombok.Data;
//@Data
public class LevelDto {
	private int id;
	private String name;
	
	private int depth;
	
	private int algorithmId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getAlgorithmId() {
		return algorithmId;
	}

	public void setAlgorithmId(int algorithmId) {
		this.algorithmId = algorithmId;
	}
	
}
