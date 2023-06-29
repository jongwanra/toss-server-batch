package com.numble.tossserverbatch.domain;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private  String name;

    @Column(length = 8, nullable = false)
    private String birthDay;

    public static Member createMember(String name, String birthDay) {
        Member createdMember = new Member();
        createdMember.name = name;
        createdMember.birthDay = birthDay;

        return createdMember;
    }
}
