package com.numble.tossserverbatch.service;


import com.numble.tossserverbatch.api.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.Member;
import com.numble.tossserverbatch.domain.MemberStatus;
import com.numble.tossserverbatch.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("정상적인 회원 가입인 경우")
    public void signUpTest1() throws Exception {
        // given
        String givenName = "jongwanra";
        String givenBirthDay = "19951209";
        MemberSignUpRequestDto memberSignUpRequestDto = new MemberSignUpRequestDto();
        memberSignUpRequestDto.setName(givenName);
        memberSignUpRequestDto.setBirthDay(givenBirthDay);

        // when
        Long memberId = memberService.signUp(memberSignUpRequestDto);
        Member createdMember = memberRepository.findOne(memberId);


        // then
        assertEquals("회원 가입 된 멤버 이름 확인", givenName, createdMember.getName());
        assertEquals("회원 가입 된 멤버 BirthDay 확인", givenBirthDay, createdMember.getBirthDay());
        assertEquals("회원 가입 된 멤버 상태 확인", MemberStatus.ACTIVE, createdMember.getStatus());
    }


    @Test
    @DisplayName("이미 등록된 회원 이름으로 가입하는 경우")
    public void signUpTest2() throws Exception {
        // given
        String givenName = "jongwanra";
        String givenBirthDay = "19951209";

        MemberSignUpRequestDto memberSignUpRequestDto = new MemberSignUpRequestDto();
        memberSignUpRequestDto.setName(givenName);
        memberSignUpRequestDto.setBirthDay(givenBirthDay);


        MemberSignUpRequestDto duplicatedMemberSignUpRequestDto = new MemberSignUpRequestDto();
        duplicatedMemberSignUpRequestDto.setName(givenName);
        memberSignUpRequestDto.setBirthDay("19940217");


        // when
        Long memberId = memberService.signUp(memberSignUpRequestDto);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            memberService.signUp(duplicatedMemberSignUpRequestDto);
        });

        // then
        Assertions.assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
    }

}