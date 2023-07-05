package com.numble.tossserverbatch.domain.quote.entity;

import com.numble.tossserverbatch.domain.BaseTimeEntity;
import com.numble.tossserverbatch.domain.member.entity.Member;
import com.numble.tossserverbatch.domain.stock.entity.Stock;
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
public class Quote extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "quote_id")
    private Long id;

    @Column
    private Long quotePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stock_id", nullable = false)
    private Stock stock;


}
