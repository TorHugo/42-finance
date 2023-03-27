package com.br.finance.mapper;

import com.br.finance.model.dto.CategoryDTO;
import com.br.finance.model.entity.CategoryModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class CategoryMapper {
    public CategoryModel mapper(final CategoryDTO dto){
        CategoryModel model = new CategoryModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setDescription(dto.getDescription());
        model.setMonthlyBudget(dto.getMonthlyBudget());
        model.setTotalSpend(BigDecimal.ZERO);
        model.setDateInclusion(LocalDateTime.now());
        model.setDateUpdate(Objects.isNull(dto.getDateUpdate()) ? null : LocalDateTime.now());

        return model;
    }
}
