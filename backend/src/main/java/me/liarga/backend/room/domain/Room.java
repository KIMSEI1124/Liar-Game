package me.liarga.backend.room.domain;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.liarga.backend.common.converter.ParticipantDequeConverter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class Room {
	@Column(name = "room_id", length = 36)
	@GeneratedValue(strategy = GenerationType.UUID)
	@Id
	private String id;

	@Column(nullable = false, unique = true, length = 6)
	@Size(min = 6, max = 6)
	private String serialNumber;

	/* 문제 카테고리 정하기 */

	@Column(name = "host_id", nullable = false, length = 36)
	private String hostId;

	@Builder.Default
	@Convert(converter = ParticipantDequeConverter.class)
	@Column(columnDefinition = "TEXT")
	private Deque<String> participants = new ArrayDeque<>();

	public static Room from(String hostId) {
		Room room = Room.builder()
			.id(UUID.randomUUID().toString())
			.serialNumber(String.format("%06d", ThreadLocalRandom.current().nextInt(0, 1_000_000)))
			.hostId(hostId)
			.build();

		room.join(hostId);
		room.transferOwnership();

		return room;
	}

	public void join(String memberId) {
		participants.addLast(memberId);
	}

	public void leave(String memberId) {
		participants.remove(memberId);
	}

	public void transferOwnership() {
		hostId = participants.getFirst();
	}

	public int getParticipantCount() {
		return participants.size();
	}
}