package com.numble.tossserverbatch.domain.stock.entity;

import com.numble.tossserverbatch.domain.BaseTimeEntity;
import com.numble.tossserverbatch.domain.account.entity.Account;
import com.numble.tossserverbatch.domain.quote.entity.Quote;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Slf4j
@ToString
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Stock extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "stock_id")
    private Long id;

    @Column(nullable = false)
    private String stockName;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private Long stockPrice;

    @OneToMany(mappedBy = "stock")
    private List<Quote> quotes = new ArrayList<>();
}