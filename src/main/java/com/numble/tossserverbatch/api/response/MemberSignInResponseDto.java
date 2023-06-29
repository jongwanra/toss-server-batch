package com.numble.tossserverbatch.api.response;

import lombok.Getter;

@Getter
public class MemberSignInResponseDto {
    private String accessToken;
    private String refreshToken;

    public MemberSignInResponseDto(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
