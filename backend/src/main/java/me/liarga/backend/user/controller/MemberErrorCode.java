package me.liarga.backend.user.controller;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.liarga.backend.common.exception.ExceptionErrorCode;

@AllArgsConstructor
@Getter
public enum MemberErrorCode implements ExceptionErrorCode {
	EMPTY_NICKNAME(HttpStatus.BAD_REQUEST, "MEMBER_001", "닉네임은 비어있으면 안됩니다."),
	INVALID_NICKNAME_LENGTH(HttpStatus.BAD_REQUEST, "MEMBER_002", "닉네임의 길이는 최소 3자부터 최대 9자까지 가능합니다.");

	private final HttpStatus httpStatus;
	private final String errorCode;
	private final String message;
}