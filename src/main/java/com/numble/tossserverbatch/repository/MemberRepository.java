package com.numble.tossserverbatch.repository;


import com.numble.tossserverbatch.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public Long save(Member member) {
        System.out.println(":: before persist");
        em.persist(member);
        return member.getId();
    }
}
