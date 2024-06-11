package com.dnpa.chess.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.dnpa.chess.dto.ResponseObject;



@RestControllerAdvice
public class ExceptionHandlerController {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseObject> handle(Exception ex, WebRequest request){
		return ResponseEntity.badRequest().body(new ResponseObject(ex.getMessage(),
																HttpStatus.BAD_REQUEST
															,ex.getMessage()));
	}
}
