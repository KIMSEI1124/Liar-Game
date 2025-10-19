package me.liarga.backend.common.converter;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ParticipantDequeConverter implements AttributeConverter<Deque<String>, String> {

	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public String convertToDatabaseColumn(Deque<String> deque) {
		try {
			if (deque == null || deque.isEmpty()) {
				return "[]";
			}
			return objectMapper.writeValueAsString(deque);
		} catch (JsonProcessingException e) {
			throw new IllegalStateException("Deque → JSON 변환 실패", e);
		}
	}

	@Override
	public Deque<String> convertToEntityAttribute(String json) {
		try {
			if (json == null || json.isBlank()) {
				return new ArrayDeque<>();
			}
			List<String> list = objectMapper.readValue(json, new TypeReference<>() {
			});
			return new ArrayDeque<>(list);
		} catch (IOException e) {
			throw new IllegalStateException("JSON → Deque 변환 실패", e);
		}
	}
}