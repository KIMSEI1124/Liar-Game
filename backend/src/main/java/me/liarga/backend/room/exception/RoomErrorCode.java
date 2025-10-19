package me.liarga.backend.room.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.liarga.backend.common.exception.ExceptionErrorCode;

@AllArgsConstructor
@Getter
public enum RoomErrorCode implements ExceptionErrorCode {
	;
	private final HttpStatus httpStatus;
	private final String errorCode;
	private final String message;
}
