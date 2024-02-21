package com.dnpa.chess.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
//@AllArgsConstructor
public class SignInDto {
	@NotBlank(message = "Tên đăng nhập không để trống")
	private String username;
	
	@NotBlank(message = "Mật khẩu không để trống")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
