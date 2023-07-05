package com.numble.tossserverbatch.domain.account.service;

import com.numble.tossserverbatch.domain.account.controller.dto.request.CreateAccountRequestDto;
import com.numble.tossserverbatch.domain.account.controller.dto.request.DeleteAccountRequestDto;
import com.numble.tossserverbatch.domain.account.entity.Account;

import java.util.List;

public interface AccountService {
    Long createAccount(Long memberId, CreateAccountRequestDto request);

    void deleteAccount(Long memberId, DeleteAccountRequestDto request);

    List<Account> findAllByMemberAndStatus(Long memberId);
}
