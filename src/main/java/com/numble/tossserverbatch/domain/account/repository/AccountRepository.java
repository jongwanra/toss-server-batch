package com.numble.tossserverbatch.domain.account.repository;

import com.numble.tossserverbatch.domain.account.entity.Account;
import com.numble.tossserverbatch.domain.account.entity.AccountStatus;
import com.numble.tossserverbatch.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByMemberAndStatus(Member member, AccountStatus status);

    Optional<Account> findByIdAndStatus(Long accountId, AccountStatus status);



}
