package com.br.finance.repository;

import com.br.finance.model.entity.BalanceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceRepository extends JpaRepository<BalanceModel, Long> {
    List<BalanceModel> findByIdCategory(Long idCategory);
}
