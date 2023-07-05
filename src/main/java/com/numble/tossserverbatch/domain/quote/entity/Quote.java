package com.numble.tossserverbatch.domain.quote.entity;

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
public class Quote extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "quote_id")
    private Long id;
}
