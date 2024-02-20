package com.dnpa.chess.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class SignInDto {
	@NotBlank(message = "Tên đăng nhập không để trống")
	private String username;
	
	@NotBlank(message = "Mật khẩu không để trống")
	private String password;

}
