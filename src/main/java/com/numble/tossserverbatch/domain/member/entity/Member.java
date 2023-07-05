package com.numble.tossserverbatch.domain.member.entity;
import com.numble.tossserverbatch.domain.BaseTimeEntity;
import com.numble.tossserverbatch.domain.account.entity.Account;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String name;

    @Column(length = 8, nullable = false)
    private String birthDay;

    @Column(nullable = false, columnDefinition = "TEXT" )
    private String hashedPassword;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    // ACTIVE, DELETED
    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    @OneToMany(mappedBy = "member")
    private List<Account> accounts = new ArrayList<>();

    public static Member createMember(String loginId, String name, String birthDay, String hashedPassword, MemberRole role) {
        Member createdMember = new Member();
        createdMember.loginId = loginId;
        createdMember.name = name;
        createdMember.birthDay = birthDay;
        createdMember.hashedPassword = hashedPassword;
        createdMember.status = MemberStatus.ACTIVE;
        createdMember.role = role;

        return createdMember;
    }

    public void deleteMember() {
        this.status = MemberStatus.DELETED;
    }
}
