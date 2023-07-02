package com.numble.tossserverbatch.domain.auth.service;

import com.numble.tossserverbatch.domain.auth.controller.dto.request.SignInRequestDto;
import com.numble.tossserverbatch.domain.auth.controller.dto.response.SignInResponseDto;

public interface AuthService {
    SignInResponseDto signIn(SignInRequestDto requestDto) throws Exception;
}
