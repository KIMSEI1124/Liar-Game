package me.liarga.backend.room.dto;

import org.hibernate.validator.constraints.UUID;

import jakarta.validation.constraints.NotBlank;

public record RoomCreateRequest(
	@NotBlank
	@UUID
	String hostId
) {
}