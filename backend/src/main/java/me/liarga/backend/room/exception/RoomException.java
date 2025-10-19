package me.liarga.backend.room.exception;

import me.liarga.backend.common.exception.ExceptionErrorCode;
import me.liarga.backend.common.exception.LiarGameException;

public class RoomException extends LiarGameException {
	public RoomException(ExceptionErrorCode exceptionErrorCode) {
		super(exceptionErrorCode);
	}
}