package com.numble.tossserverbatch.service;


import com.numble.tossserverbatch.domain.auth.controller.dto.request.SignInRequestDto;
import com.numble.tossserverbatch.domain.auth.controller.dto.response.SignInResponseDto;
import com.numble.tossserverbatch.domain.auth.service.AuthService;
import com.numble.tossserverbatch.domain.member.controller.dto.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.member.entity.Member;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import com.numble.tossserverbatch.domain.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class AuthServiceTest {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    AuthService authService;
    @Autowired
    MemberService memberService;


    @Test
    @DisplayName("로그인")
    public void signInTest() throws Exception {
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

        Long userId = memberService.signUp(userSignUpRequestDto);
        Member createdUser = memberRepository.findById(userId).orElseThrow();
        // when
        SignInResponseDto signInResponseDto = authService.signIn(new SignInRequestDto(givenLoginId, givenPassword));

        System.out.println("signInResponseDto = " + signInResponseDto.getAccessToken());


        // then
//        assertEquals("회원 가입 된 멤버 로그인 ID 확인", givenLoginId, createdUser.getLoginId());
//        assertEquals("회원 가입 된 멤버 이름 확인", givenName, createdUser.getName());
//        assertEquals("회원 가입 된 멤버 BirthDay 확인", givenBirthDay, createdUser.getBirthDay());
//        assertEquals("회원 가입 된 멤버 상태 확인", MemberStatus.ACTIVE, createdUser.getStatus());
    }
}
