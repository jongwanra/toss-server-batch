package com.numble.tossserverbatch.service;

import com.numble.tossserverbatch.domain.account.controller.dto.request.CreateAccountRequestDto;
import com.numble.tossserverbatch.domain.account.entity.Account;
import com.numble.tossserverbatch.domain.account.entity.AccountStatus;
import com.numble.tossserverbatch.domain.account.repository.AccountRepository;
import com.numble.tossserverbatch.domain.account.service.AccountService;
import com.numble.tossserverbatch.domain.member.controller.dto.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.member.entity.Member;
import com.numble.tossserverbatch.domain.member.entity.MemberStatus;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import com.numble.tossserverbatch.domain.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
@Transactional
public class AccountServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;


    @Test
    @DisplayName("계좌 등록")
    @Rollback(value = false)
    public void createAccountTest1() throws Exception {
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

        Long memberId = memberService.signUp(userSignUpRequestDto);
        Member createdMember = memberRepository.findById(memberId).orElseThrow();

        String givenBank = "우리은행";
        String givenAccountNumber = "1002-100-123456";
        Long givenBalance =  10000L;

        CreateAccountRequestDto createAccountRequestDto = new CreateAccountRequestDto(givenBank, givenAccountNumber, givenBalance);


        // when

        Long accountId = accountService.createAccount(memberId, createAccountRequestDto);
        Account createdAccount = accountRepository.findByIdAndStatus(accountId, AccountStatus.ACTIVE).get();

        // then
        assertEquals("생성된 계좌 은행 확인", givenBank, createdAccount.getBank());
        assertEquals("회원 가입 된 멤버 이름 확인", givenAccountNumber, createdAccount.getAccountNumber());

    }
}
