package me.liarga.backend.user.dto;

import static me.liarga.backend.user.constant.MemberConst.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MemberSignupRequest(
	@NotBlank
	@Size(min = MIN_NICKNAME_LENGTH, max = MAX_NICKNAME_LENGTH)
	String nickname
) {
}