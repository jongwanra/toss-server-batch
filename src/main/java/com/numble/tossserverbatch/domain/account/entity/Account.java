package com.numble.tossserverbatch.domain.account.entity;

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
public class Account extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "accoubt_id")
    private Long id;
}
