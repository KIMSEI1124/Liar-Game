package me.liarga.backend.room.dto;

import me.liarga.backend.room.domain.Room;

public record RoomCreateResponse(
	String roomId,
	String serialNumber
) {
	public static RoomCreateResponse from(Room room) {
		return new RoomCreateResponse(room.getId(), room.getSerialNumber());
	}
}