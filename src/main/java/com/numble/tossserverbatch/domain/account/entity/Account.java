package com.numble.tossserverbatch.domain.account.entity;

import com.numble.tossserverbatch.domain.BaseTimeEntity;
import com.numble.tossserverbatch.domain.member.entity.Member;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@Slf4j
@ToString
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @Column
    private String bank;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private Long balance;

    @Column(nullable = false)
    private AccountStatus status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id", nullable = false)
    private Member member;

    public static Account createAccount(String bank, String accountNumber, Long balance, Member member){
        Account createdAccount = new Account();
        createdAccount.bank = bank;
        createdAccount.accountNumber = accountNumber;
        createdAccount.balance = balance;
        createdAccount.member = member;
        createdAccount.status = AccountStatus.ACTIVE;

        return createdAccount;
    }

    public void deleteAccount(){
        this.status = AccountStatus.DELETED;
    }
}
