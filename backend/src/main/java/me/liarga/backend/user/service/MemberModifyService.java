package me.liarga.backend.user.service;

import me.liarga.backend.user.dto.MemberSignupRequest;
import me.liarga.backend.user.dto.MemberSignupResponse;

public interface MemberModifyService {
	/**
	 * 신규 사용자가 서비스에 가입한다.
	 *
	 * @param request 사용자가 사용하려고 하는 닉네임
	 * @return 사용자 식별자
	 */
	MemberSignupResponse signup(MemberSignupRequest request);
}