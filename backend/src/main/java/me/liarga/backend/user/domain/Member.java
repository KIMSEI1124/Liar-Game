package me.liarga.backend.user.domain;

import static me.liarga.backend.user.constant.MemberConst.*;

import org.hibernate.validator.constraints.Range;
import org.springframework.util.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.liarga.backend.user.controller.MemberErrorCode;
import me.liarga.backend.user.exception.MemberException;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@Column(nullable = false)
	@Range(min = 3, max = 9)
	private String nickname;

	public static Member from(String nickname) {
		/* Prepare Process */
		validateNickname(nickname);

		/* Post Process */
		return Member.builder()
			.nickname(nickname)
			.build();
	}

	private static void validateNickname(final String nickname) {
		if (StringUtils.hasText(nickname)) {
			throw new MemberException(MemberErrorCode.EMPTY_NICKNAME);
		}

		int nicknameLength = nickname.length();
		if (nicknameLength < MIN_NICKNAME_LENGTH || MAX_NICKNAME_LENGTH < nicknameLength) {
			throw new MemberException(MemberErrorCode.INVALID_NICKNAME_LENGTH);
		}
	}
}