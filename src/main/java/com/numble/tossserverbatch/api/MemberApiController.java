package com.numble.tossserverbatch.api;
import com.numble.tossserverbatch.api.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.api.response.MemberSignUpResponseDto;
import com.numble.tossserverbatch.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    @PostMapping("/api/sign-up")
    public MemberSignUpResponseDto signUp(@RequestBody @Valid MemberSignUpRequestDto request) {
        Long memberId = memberService.signUp(request.getName(), request.getBirthDay());
        return new MemberSignUpResponseDto(memberId);
    }
}
