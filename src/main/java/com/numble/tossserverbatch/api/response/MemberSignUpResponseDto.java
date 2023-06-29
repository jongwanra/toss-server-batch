package com.numble.tossserverbatch.api.response;

import com.numble.tossserverbatch.domain.Member;
import lombok.Getter;

@Getter
public class MemberSignUpResponseDto {
    private Long id;
    public MemberSignUpResponseDto(Long id) {
        this.id = id;
    }
}
