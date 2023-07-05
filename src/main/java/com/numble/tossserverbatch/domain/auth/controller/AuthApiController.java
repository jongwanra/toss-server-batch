package com.numble.tossserverbatch.domain.auth.controller;

import com.numble.tossserverbatch.domain.auth.controller.dto.request.SignInRequestDto;
import com.numble.tossserverbatch.domain.auth.controller.dto.response.SignInResponseDto;
import com.numble.tossserverbatch.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Slf4j
public class AuthApiController {
    private final AuthService authService;


    @PostMapping
    public ResponseEntity<SignInResponseDto> signIn(@Valid @RequestBody SignInRequestDto request) throws Exception {
        return ResponseEntity.ok(authService.signIn(request));
    }

//    @PostMapping("/reissue-refresh-token")
//    public ResponseEntity<?> reissueRefreshToken() throws Exception {
//
//        return ResponseEntity.ok(200);
//    }
}
