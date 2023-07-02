package com.numble.tossserverbatch.domain.member.controller.dto.response;

import com.numble.tossserverbatch.domain.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberSignUpResponseDto {
    private Long id;
    private String name;
    
    public MemberSignUpResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
    }
}
