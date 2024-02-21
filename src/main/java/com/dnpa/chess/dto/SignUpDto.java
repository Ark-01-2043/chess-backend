package com.dnpa.chess.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

//@Data
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
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
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
	public String getConfirmedPassword() {
		return confirmedPassword;
	}
	public void setConfirmedPassword(String confirmedPassword) {
		this.confirmedPassword = confirmedPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
}
