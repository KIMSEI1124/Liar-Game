package me.liarga.backend.room.service;

import me.liarga.backend.room.dto.RoomCreateRequest;
import me.liarga.backend.room.dto.RoomCreateResponse;

public interface RoomModifyService {
	RoomCreateResponse createRoom(RoomCreateRequest request);
}