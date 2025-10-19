package me.liarga.backend.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class LiarGameException extends RuntimeException {
	private final HttpStatus statusCode;
	private final String errorCode;
	private final String message;

	public LiarGameException(ExceptionErrorCode exceptionErrorCode) {
		this.statusCode = exceptionErrorCode.getHttpStatus();
		this.errorCode = exceptionErrorCode.getErrorCode();
		this.message = exceptionErrorCode.getMessage();
	}
}