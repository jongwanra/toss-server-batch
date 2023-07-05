package com.numble.tossserverbatch.domain.stock.repository;

import com.numble.tossserverbatch.domain.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
