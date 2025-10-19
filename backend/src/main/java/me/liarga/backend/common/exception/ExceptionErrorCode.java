package me.liarga.backend.common.exception;

import org.springframework.http.HttpStatus;

public interface ExceptionErrorCode {
	HttpStatus getHttpStatus();

	String getErrorCode();

	String getMessage();
}