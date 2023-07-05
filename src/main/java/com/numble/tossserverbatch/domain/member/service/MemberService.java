package com.numble.tossserverbatch.domain.member.service;

import com.numble.tossserverbatch.domain.member.controller.dto.request.MemberSignUpRequestDto;

public interface MemberService {
    Long signUp(MemberSignUpRequestDto request);

    void deleteMember(Long memberId);
}
