package com.numble.tossserverbatch.domain.transaction.entity;

import com.numble.tossserverbatch.domain.BaseTimeEntity;
import com.numble.tossserverbatch.domain.account.entity.Account;
import com.numble.tossserverbatch.domain.stock.entity.Stock;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Slf4j
@ToString
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Transaction extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Long id;

    // TRANSFER(송금), BUY(주식 구매), SELL(주식 판매)
    @Enumerated(EnumType.STRING)
    private TrasactionType trasactionType;

    private Long transactionPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    @Column
    private String receiverAccountNumber;

    @Column
    private LocalDateTime sendAt;

}
