package com.numble.tossserverbatch.domain.account.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountRequestDto {
    private String bank;
    private String accountNumber;
    private Long balance;

    @Builder
    public CreateAccountRequestDto(String bank, String accountNumber, Long balance){
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.balance = balance;

    }

}
