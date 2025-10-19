package me.liarga.backend.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import me.liarga.backend.user.constant.MemberConst;

public record MemberSignupRequest(
	@NotBlank
	@Size(min = MemberConst.MIN_NICKNAME_LENGTH, max = MemberConst.MAX_NICKNAME_LENGTH)
	String nickname
) {
}