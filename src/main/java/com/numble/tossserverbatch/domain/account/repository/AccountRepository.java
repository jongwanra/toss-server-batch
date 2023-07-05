package com.numble.tossserverbatch.domain.account.repository;

import com.numble.tossserverbatch.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
