package com.numble.tossserverbatch.domain.transaction.repository;

import com.numble.tossserverbatch.domain.transaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
