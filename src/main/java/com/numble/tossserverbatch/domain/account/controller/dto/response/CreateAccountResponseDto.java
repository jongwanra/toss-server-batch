package com.numble.tossserverbatch.domain.account.controller.dto.response;
import com.numble.tossserverbatch.domain.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateAccountResponseDto {

    private Long id;
    private String bank;
    private String accountNumber;
    private Long balance;


    public CreateAccountResponseDto(Account account){
        id = account.getId();
        bank = account.getBank();
        accountNumber = account.getAccountNumber();
        balance = account.getBalance();

    }

}
