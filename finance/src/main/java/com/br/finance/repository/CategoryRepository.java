package com.br.finance.repository;

import com.br.finance.model.entity.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    Optional<CategoryModel> findByName(String name);
}
