package com.numble.tossserverbatch.domain.member.repository;
import com.numble.tossserverbatch.domain.member.entity.Member;
import com.numble.tossserverbatch.domain.member.entity.MemberStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByNameAndStatus(String name, MemberStatus status);

    Optional<Member> findByIdAndStatus(Long id, MemberStatus status);

    Optional<Member> findByLoginIdAndStatus(String loginId, MemberStatus status);
}
