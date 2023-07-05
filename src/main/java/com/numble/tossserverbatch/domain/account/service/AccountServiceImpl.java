package com.numble.tossserverbatch.domain.account.service;


import com.numble.tossserverbatch.domain.account.controller.dto.request.CreateAccountRequestDto;
import com.numble.tossserverbatch.domain.account.controller.dto.request.DeleteAccountRequestDto;
import com.numble.tossserverbatch.domain.account.entity.Account;
import com.numble.tossserverbatch.domain.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;


    @Override
    public Long createAccount(CreateAccountRequestDto request) {
        return 0L;
    }

    @Override
    public void deleteAccount(DeleteAccountRequestDto request) {
        return;
    }
}
