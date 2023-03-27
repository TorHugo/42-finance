package com.br.finance.model.dto;

import com.br.finance.model.entity.CategoryModel;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal monthlyBudget;
    private LocalDateTime dateInclusion;
    private LocalDateTime dateUpdate;

    public CategoryDTO(CategoryModel model){
        this.id = model.getId();
        this.name = model.getName();
        this.description = model.getDescription();
        this.monthlyBudget = model.getMonthlyBudget();
        this.dateInclusion = model.getDateInclusion();
        this.dateUpdate = model.getDateUpdate();
    }

    public CategoryDTO(Long id, String name, String description, BigDecimal monthlyBudget, LocalDateTime dateInclusion, LocalDateTime dateUpdate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.monthlyBudget = monthlyBudget;
        this.dateInclusion = dateInclusion;
        this.dateUpdate = dateUpdate;
    }

    public CategoryDTO(){   }
}