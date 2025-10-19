package me.liarga.backend.user.dto;

public record MemberSignupResponse(
	int memberId
) {
	public static MemberSignupResponse from(int memberId) {
		return new MemberSignupResponse(memberId);
	}
}