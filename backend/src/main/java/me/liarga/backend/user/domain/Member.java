package me.liarga.backend.user.domain;

import static me.liarga.backend.user.constant.MemberConst.*;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.util.StringUtils;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
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
@RedisHash
public class Member {
	@Column(name = "member_id", length = 36)
	@GeneratedValue(strategy = GenerationType.UUID)
	@Id
	private String id;

	@Column(nullable = false, length = 9)
	@Size(min = 3, max = 9)
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
		if (!StringUtils.hasText(nickname)) {
			throw new MemberException(MemberErrorCode.EMPTY_NICKNAME);
		}

		int nicknameLength = nickname.length();
		if (nicknameLength < MIN_NICKNAME_LENGTH || MAX_NICKNAME_LENGTH < nicknameLength) {
			throw new MemberException(MemberErrorCode.INVALID_NICKNAME_LENGTH);
		}
	}
}