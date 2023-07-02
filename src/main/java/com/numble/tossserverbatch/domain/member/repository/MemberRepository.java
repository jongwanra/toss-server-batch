package com.numble.tossserverbatch.domain.member.repository;
import com.numble.tossserverbatch.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    Optional<Member> findByLoginId(String loginId);
}
