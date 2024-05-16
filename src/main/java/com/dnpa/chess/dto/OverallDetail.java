package com.dnpa.chess.dto;

import java.util.List;

import com.dnpa.chess.entity.User;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class OverallDetail {
	private User user;
	private List<ThongKeCheDo> thongke;
}
