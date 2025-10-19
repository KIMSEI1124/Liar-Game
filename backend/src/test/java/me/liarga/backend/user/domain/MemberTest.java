package me.liarga.backend.user.domain;

import org.junit.jupiter.api.Test;

class MemberTest {
	@Test
	void fromTest() {
		Member member = Member.from("12");

		System.out.println(member.getNickname());
	}
}