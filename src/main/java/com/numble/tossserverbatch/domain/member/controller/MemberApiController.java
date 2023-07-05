package com.numble.tossserverbatch.domain.member.controller;

import com.numble.tossserverbatch.domain.member.controller.dto.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.member.controller.dto.response.MemberSignUpResponseDto;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import com.numble.tossserverbatch.domain.member.service.MemberService;
import com.numble.tossserverbatch.global.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public ResponseEntity<Result<MemberSignUpResponseDto>> signUp(@RequestBody @Valid MemberSignUpRequestDto request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new Error(bindingResult.toString());
        }
        Long memberId = memberService.signUp(request);
        return ResponseEntity
                .ok()
                .body(new Result<>(new MemberSignUpResponseDto(memberRepository.findById(memberId).orElseThrow()), 200, "Success"));
    }

    @DeleteMapping()
    public ResponseEntity<Result<?>> deleteMember(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        Long memberId = Long.parseLong(userDetails.getUsername());
        memberService.deleteMember(memberId);
        return ResponseEntity.ok()
                .body(new Result<>(200));
    }

}

