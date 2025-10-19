package me.liarga.backend.common.converter;

import java.util.ArrayDeque;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantDequeConverterTest {
	@DisplayName("")
	@Test
	void converterTest() {
		/* Given */
		ParticipantDequeConverter converter = new ParticipantDequeConverter();

		ArrayDeque<String> deque = new ArrayDeque<>();
		deque.addLast(String.valueOf(UUID.randomUUID()));
		deque.addLast(String.valueOf(UUID.randomUUID()));
		deque.addLast(String.valueOf(UUID.randomUUID()));
		String s = converter.convertToDatabaseColumn(deque);
		/* When */
		System.out.println(s);

		/* Then */

	}
}