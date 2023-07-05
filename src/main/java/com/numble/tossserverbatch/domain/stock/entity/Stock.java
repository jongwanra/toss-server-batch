package com.numble.tossserverbatch.domain.stock.entity;

import com.numble.tossserverbatch.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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


}