package com.dnpa.chess.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class ChangePasswordDto {
	@NotBlank(message = "Không được để trống mật khẩu cũ")
	private String password;
	@NotBlank(message = "Không được để trống mật khẩu mới")
	@Size(min = 8, max = 32, message = "Mật khẩu phải từ 8-32 ký tự")
	private String newPassword;
	@NotBlank(message = "Không được để trống mật khẩu nhập lại")
	private String confirmedPassword;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	public ChangePasswordDto(@NotBlank(message = "Không được để trống mật khẩu cũ") String password,
			@NotBlank(message = "Không được để trống mật khẩu mới") @Size(min = 8, max = 32, message = "Mật khẩu phải từ 8-32 ký tự") String newPassword,
			@NotBlank(message = "Không được để trống mật khẩu nhập lại") String confirmedPassword) {
		super();
		this.password = password;
		this.newPassword = newPassword;
		this.confirmedPassword = confirmedPassword;
	}
	public ChangePasswordDto() {
		super();
	}
	
}
