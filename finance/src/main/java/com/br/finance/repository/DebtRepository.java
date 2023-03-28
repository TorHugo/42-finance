package com.br.finance.repository;

import com.br.finance.model.entity.DebtModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepository extends JpaRepository<DebtModel, Long> {
}
