package com.dnpa.chess.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Builder
public class Algorithm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Tên không để trống")
	private String name;
	@NotBlank(message = "File không để trống")
	private String path;
	public Algorithm(Integer id, @NotBlank(message = "Tên không để trống") String name,
			@NotBlank(message = "File không để trống") String path) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
	}
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Algorithm() {
		super();
	}
	
	
}