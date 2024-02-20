package com.dnpa.chess.exception;

public class HttpResponse extends RuntimeException {
    public HttpResponse(String message) {
        super(message);
    }
}