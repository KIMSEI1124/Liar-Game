package me.liarga.backend.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.liarga.backend.user.domain.Member;
import me.liarga.backend.user.domain.MemberRepository;
import me.liarga.backend.user.dto.MemberSignupRequest;
import me.liarga.backend.user.dto.MemberSignupResponse;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService implements MemberFindService, MemberModifyService {

	private final MemberRepository memberRepository;

	@Transactional
	@Override
	public MemberSignupResponse signup(MemberSignupRequest request) {
		/* Prepare Process*/
		Member member = Member.from(request.nickname());

		/* Main Process */
		Member savedMember = memberRepository.save(member);

		/* Post Process */
		return MemberSignupResponse.from(savedMember.getId());
	}
}