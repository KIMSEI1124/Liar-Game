package me.liarga.backend.room.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import me.liarga.backend.room.dto.RoomCreateRequest;
import me.liarga.backend.room.dto.RoomCreateResponse;
import me.liarga.backend.room.service.RoomModifyService;

@AllArgsConstructor
@RequestMapping("/room")
@RestController
public class RoomController {

	private final RoomModifyService roomModifyService;

	@PostMapping("/create")
	public ResponseEntity<RoomCreateResponse> createRoom(
		@Valid @RequestBody RoomCreateRequest request
	) {
		RoomCreateResponse response = roomModifyService.createRoom(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}