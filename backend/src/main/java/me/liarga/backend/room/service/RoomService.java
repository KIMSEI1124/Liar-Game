package me.liarga.backend.room.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import me.liarga.backend.room.domain.Room;
import me.liarga.backend.room.domain.RoomRepository;
import me.liarga.backend.room.dto.RoomCreateRequest;
import me.liarga.backend.room.dto.RoomCreateResponse;

@AllArgsConstructor
@Transactional(readOnly = true)
@Service
public class RoomService implements RoomFindService, RoomModifyService {
	private final RoomRepository roomRepository;

	@Transactional
	@Override
	public RoomCreateResponse createRoom(RoomCreateRequest request) {
		// TODO: 중복제거 확인 필요 -> 1. 중복일 경우 새로 만들어서 다시 진행
		/* Prepare Process */
		Room room = Room.from(request.hostId());

		/* Main Process */
		Room savedRoom = roomRepository.save(room);

		/* Post Process */
		return RoomCreateResponse.from(savedRoom);
	}
}