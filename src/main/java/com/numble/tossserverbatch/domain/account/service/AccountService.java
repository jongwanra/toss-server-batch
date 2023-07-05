package com.numble.tossserverbatch.domain.account.service;

import com.numble.tossserverbatch.domain.account.controller.dto.request.CreateAccountRequestDto;
import com.numble.tossserverbatch.domain.account.controller.dto.request.DeleteAccountRequestDto;

public interface AccountService {
    Long createAccount(CreateAccountRequestDto request);

    void deleteAccount(DeleteAccountRequestDto request);
}
