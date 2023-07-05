package com.numble.tossserverbatch.domain.quote.repository;

import com.numble.tossserverbatch.domain.quote.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
