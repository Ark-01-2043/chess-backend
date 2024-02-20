package com.dnpa.chess.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class AlgorithmDTO {
	@NotBlank(message = "Tên không để trống")
	private String name;
	private MultipartFile multipartFile;
}
