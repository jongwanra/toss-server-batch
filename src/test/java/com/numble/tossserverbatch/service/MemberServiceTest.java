package com.numble.tossserverbatch.service;


import com.numble.tossserverbatch.domain.member.controller.dto.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.member.entity.Member;
import com.numble.tossserverbatch.domain.member.entity.type.MemberStatus;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import com.numble.tossserverbatch.domain.member.service.MemberService;
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
    MemberService userService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("정상적인 회원 가입인 경우")
    public void signUpTest1() throws Exception {
        // given
        String givenName = "jongwanra";
        String givenBirthDay = "19951209";
        String givenLoginId = "abctest";
        String givenPassword = "test123!!";
        MemberSignUpRequestDto userSignUpRequestDto = new MemberSignUpRequestDto();
        userSignUpRequestDto.setLoginId(givenLoginId);
        userSignUpRequestDto.setName(givenName);
        userSignUpRequestDto.setBirthDay(givenBirthDay);
        userSignUpRequestDto.setPassword(givenPassword);

        // when
        Long userId = userService.signUp(userSignUpRequestDto);
        Member createdUser = memberRepository.findById(userId).orElseThrow();


        // then
        assertEquals("회원 가입 된 멤버 로그인 ID 확인", givenLoginId, createdUser.getLoginId());
        assertEquals("회원 가입 된 멤버 이름 확인", givenName, createdUser.getName());
        assertEquals("회원 가입 된 멤버 BirthDay 확인", givenBirthDay, createdUser.getBirthDay());
        assertEquals("회원 가입 된 멤버 상태 확인", MemberStatus.ACTIVE, createdUser.getStatus());
    }


    @Test
    @DisplayName("이미 등록된 회원 이름으로 가입하는 경우")
    public void signUpTest2() throws Exception {
        // given
        String givenName = "jongwanra";
        String givenBirthDay = "19951209";
        String givenLoginId = "abctest";
        String givenPassword = "12341234";

        MemberSignUpRequestDto userSignUpRequestDto = new MemberSignUpRequestDto();
        userSignUpRequestDto.setLoginId(givenLoginId);
        userSignUpRequestDto.setName(givenName);
        userSignUpRequestDto.setBirthDay(givenBirthDay);
        userSignUpRequestDto.setPassword(givenPassword);


        MemberSignUpRequestDto duplicatedUserSignUpRequestDto = new MemberSignUpRequestDto();
        duplicatedUserSignUpRequestDto.setLoginId(givenLoginId);
        duplicatedUserSignUpRequestDto.setName(givenName);
        duplicatedUserSignUpRequestDto.setBirthDay("19940217");
        duplicatedUserSignUpRequestDto.setPassword(givenPassword);


        // when
        Long userId = userService.signUp(duplicatedUserSignUpRequestDto);

        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            userService.signUp(duplicatedUserSignUpRequestDto);
        });

        // then
        Assertions.assertEquals("이미 존재하는 회원입니다.", thrown.getMessage());
    }

}