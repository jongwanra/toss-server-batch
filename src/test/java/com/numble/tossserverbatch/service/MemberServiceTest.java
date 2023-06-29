package com.numble.tossserverbatch.service;


import com.numble.tossserverbatch.api.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
//    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원_가입_테스트() throws Exception {
        // given

        MemberSignUpRequestDto memberSignUpRequestDto = new MemberSignUpRequestDto();
        memberSignUpRequestDto.setName("jongwanra");
        memberSignUpRequestDto.setBirthDay("19951209");
        Long memberId = memberService.signUp(memberSignUpRequestDto);

        System.out.println("memberId = " + memberId);

        // when


        // then
    }


}