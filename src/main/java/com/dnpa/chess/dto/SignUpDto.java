package com.dnpa.chess.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SignUpDto {

	@NotBlank(message = "Họ tên không để trống")
	private String hoTen;
	@NotBlank(message = "Tên đăng nhập không để trống")
	private String username;
	
	@NotBlank(message = "Mật khẩu không để trống")
	private String password;
	@NotBlank(message = "Mật khẩu nhập lại không để trống")
	private String confirmedPassword;
	@Email(message = "Email không đúng định dạng")
	private String email;
	@NotBlank(message = "Số điện thoại không để trống")
	private String soDienThoai;
	private boolean gioiTinh;
}
