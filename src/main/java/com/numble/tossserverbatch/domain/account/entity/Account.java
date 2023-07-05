package com.numble.tossserverbatch.domain.account.entity;

import com.numble.tossserverbatch.domain.BaseTimeEntity;
import com.numble.tossserverbatch.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
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

    @Column(nullable = false)
    private Long balance;

    @Enumerated(EnumType.STRING)
    private BankType bankType;

    @Column(nullable = false)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id", nullable = false)
    private Member member;

}
