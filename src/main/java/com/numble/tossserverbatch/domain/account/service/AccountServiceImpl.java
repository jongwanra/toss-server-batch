package com.numble.tossserverbatch.domain.account.service;


import com.numble.tossserverbatch.domain.account.controller.dto.request.CreateAccountRequestDto;
import com.numble.tossserverbatch.domain.account.controller.dto.request.DeleteAccountRequestDto;
import com.numble.tossserverbatch.domain.account.entity.Account;
import com.numble.tossserverbatch.domain.account.entity.AccountStatus;
import com.numble.tossserverbatch.domain.account.repository.AccountRepository;
import com.numble.tossserverbatch.domain.member.entity.Member;
import com.numble.tossserverbatch.domain.member.entity.MemberStatus;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final MemberRepository memberRepository;


    @Override
    public Long createAccount(Long memberId, CreateAccountRequestDto request) {
        Member findMember = memberRepository.findByIdAndStatus(memberId, MemberStatus.ACTIVE)
                .orElseThrow(() -> new UsernameNotFoundException("No User"));

        Account createdAccount = Account.createAccount(request.getBank(), request.getAccountNumber(), request.getBalance(), findMember);
        return accountRepository.save(createdAccount).getId();
    }

    @Override
    public void deleteAccount(Long memberId, DeleteAccountRequestDto request) {
        memberRepository.findByIdAndStatus(memberId, MemberStatus.ACTIVE)
                .orElseThrow(() -> new UsernameNotFoundException("No User"));

        Account findAccount = accountRepository.findByIdAndStatus(request.getId(), AccountStatus.ACTIVE)
                .orElseThrow(() -> new IllegalStateException("No Account"));

        findAccount.deleteAccount();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Account> findAllByMemberAndStatus(Long memberId) {
        Member findMember = memberRepository.findByIdAndStatus(memberId, MemberStatus.ACTIVE)
                .orElseThrow(() -> new UsernameNotFoundException("No User"));
        return accountRepository.findAllByMemberAndStatus(findMember, AccountStatus.ACTIVE);
    }
}
