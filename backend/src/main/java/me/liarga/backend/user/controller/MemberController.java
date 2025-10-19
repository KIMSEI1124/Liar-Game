package me.liarga.backend.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.liarga.backend.user.dto.MemberSignupRequest;
import me.liarga.backend.user.dto.MemberSignupResponse;
import me.liarga.backend.user.service.MemberModifyService;

@RequestMapping("/member")
@RequiredArgsConstructor
@RestController
public class MemberController {
	private final MemberModifyService memberModifyService;

	@PostMapping("/signup")
	public ResponseEntity<MemberSignupResponse> registerNewMember(
		@Valid @RequestBody MemberSignupRequest request
	) {
		MemberSignupResponse response = memberModifyService.signup(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
}