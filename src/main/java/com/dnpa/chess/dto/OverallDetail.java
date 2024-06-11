package com.dnpa.chess.dto;

import java.util.List;

import com.dnpa.chess.entity.User;

import lombok.Builder;
import lombok.Data;
//@Data
//@Builder
public class OverallDetail {
	private User user;
	private List<ThongKeCheDo> thongke;
	public OverallDetail(User user, List<ThongKeCheDo> thongke) {
		super();
		this.user = user;
		this.thongke = thongke;
	}
	public OverallDetail() {
		super();
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<ThongKeCheDo> getThongke() {
		return thongke;
	}
	public void setThongke(List<ThongKeCheDo> thongke) {
		this.thongke = thongke;
	}
	
}
