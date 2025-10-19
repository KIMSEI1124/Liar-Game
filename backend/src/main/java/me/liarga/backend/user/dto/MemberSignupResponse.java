package me.liarga.backend.user.dto;

public record MemberSignupResponse(
	String memberId
) {
	public static MemberSignupResponse from(String memberId) {
		return new MemberSignupResponse(memberId);
	}
}