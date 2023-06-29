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
    //    @Rollback(false)
    public void 회원_가입_테스트() throws Exception {
        // given
        Long memberId = memberService.signUp("jongwanra", "19951209");

        // when


        // then
    }


}