package me.liarga.backend.user.exception;

import me.liarga.backend.common.exception.ExceptionErrorCode;
import me.liarga.backend.common.exception.LiarGameException;

public class MemberException extends LiarGameException {
	public MemberException(ExceptionErrorCode errorCode) {
		super(errorCode);
	}
}