package com.dnpa.chess.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String hoTen;
	private String username;
	private String password;
	private String email;
	private String soDienThoai;
	private boolean gioiTinh;
	@ManyToOne(targetEntity = Role.class)
	private Role role;

}
