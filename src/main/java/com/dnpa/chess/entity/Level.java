package com.dnpa.chess.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class Level {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private int depth;
	@ManyToOne(targetEntity = Algorithm.class)
	private Algorithm algorithm;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Algorithm getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}
	public Level(Integer id, String name, int depth, Algorithm algorithm) {
		super();
		this.id = id;
		this.name = name;
		this.depth = depth;
		this.algorithm = algorithm;
	}
	public Level() {
		super();
	}
	
	
}
