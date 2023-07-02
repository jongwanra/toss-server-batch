package com.numble.tossserverbatch.domain.auth.controller.dto.response;

import lombok.Getter;

@Getter
public class SignInResponseDto {
    private String accessToken;
    private String refreshToken;

    public SignInResponseDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
