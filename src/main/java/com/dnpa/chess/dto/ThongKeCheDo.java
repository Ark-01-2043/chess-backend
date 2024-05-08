package com.dnpa.chess.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThongKeCheDo {
	private int levelId;
	private int win;
	private int draw;
	private int lose;
}
