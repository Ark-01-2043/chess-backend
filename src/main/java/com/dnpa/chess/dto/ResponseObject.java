package com.dnpa.chess.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.http.HttpStatus;
//
//@Data//toString
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class ResponseObject {
    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("data")
    private Object data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResponseObject(String message, HttpStatus status, Object data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public ResponseObject() {
		super();
	}
    
}
