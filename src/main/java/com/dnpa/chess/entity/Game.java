package com.dnpa.chess.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime gameDate;
	private String playerSide;
	private String winner;
	private String result;
	private String move;
	@ManyToOne(targetEntity = Level.class)
	private Level level;
	@ManyToOne(targetEntity = User.class)
	private User user;
	
	
}
