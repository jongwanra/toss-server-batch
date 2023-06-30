package com.numble.tossserverbatch.service;

import com.numble.tossserverbatch.api.request.MemberSignUpRequestDto;

public interface MemberService {
    Long signUp(MemberSignUpRequestDto request);
}
