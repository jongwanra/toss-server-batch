package com.numble.tossserverbatch.domain.member.controller;

import com.numble.tossserverbatch.domain.member.controller.dto.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.member.controller.dto.response.MemberSignUpResponseDto;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import com.numble.tossserverbatch.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberApiController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;
    @PostMapping("/sign-up")
    public ResponseEntity<MemberSignUpResponseDto> signUp(@RequestBody @Valid MemberSignUpRequestDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new Error(bindingResult.toString());
        }
        Long memberId = memberService.signUp(request);
        return ResponseEntity.ok(new MemberSignUpResponseDto(memberRepository.findById(memberId).orElseThrow()));
    }
}

