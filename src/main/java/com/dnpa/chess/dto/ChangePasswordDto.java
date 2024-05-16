package com.dnpa.chess.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChangePasswordDto {
	@NotBlank(message = "Không được để trống mật khẩu cũ")
	private String password;
	@NotBlank(message = "Không được để trống mật khẩu mới")
	@Size(min = 8, max = 32, message = "Mật khẩu phải từ 8-32 ký tự")
	private String newPassword;
	@NotBlank(message = "Không được để trống mật khẩu nhập lại")
	private String confirmedPassword;
}
