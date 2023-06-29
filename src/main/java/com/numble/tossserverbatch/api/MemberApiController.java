package com.numble.tossserverbatch.api;
import com.numble.tossserverbatch.api.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.api.response.MemberSignInResponseDto;
import com.numble.tossserverbatch.api.response.MemberSignUpResponseDto;
import com.numble.tossserverbatch.repository.MemberRepository;
import com.numble.tossserverbatch.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    @PostMapping("/api/sign-up")
    public MemberSignUpResponseDto signUp(@RequestBody @Valid MemberSignUpRequestDto request) {
        Long memberId = memberService.signUp(request);
        return new MemberSignUpResponseDto(memberRepository.findOne(memberId));
    }

    @PostMapping("/api/sign-in")
    public void signIn(){

    }

}
