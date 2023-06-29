package com.numble.tossserverbatch.repository;


import com.numble.tossserverbatch.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name =:name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

    public Long save(Member member) {
        System.out.println("before- persist:" + member);
        em.persist(member);
        System.out.println("after- persist:" + member);
        return member.getId();
    }
}
