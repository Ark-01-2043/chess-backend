package com.dnpa.chess.dto;

import javax.persistence.ManyToOne;

import com.dnpa.chess.entity.Algorithm;

import lombok.Data;
@Data
public class LevelDto {
	private int id;
	private String name;
	
	private int depth;
	
	private int algorithmId;
}
