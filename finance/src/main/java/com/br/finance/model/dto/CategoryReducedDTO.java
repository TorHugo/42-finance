package com.br.finance.model.dto;

import com.br.finance.model.entity.CategoryModel;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CategoryReducedDTO {
    private String name;
    private String description;
    private BigDecimal monthlyBudget;
    private BigDecimal totalSpend;

    public CategoryReducedDTO(CategoryModel model){
        this.name = model.getName();
        this.description = model.getDescription();
        this.monthlyBudget = model.getMonthlyBudget();
        this.totalSpend = model.getTotalSpend();
    }

    public CategoryReducedDTO(String name, String description, BigDecimal monthlyBudget, BigDecimal totalSpend) {
        this.name = name;
        this.description = description;
        this.monthlyBudget = monthlyBudget;
        this.totalSpend = totalSpend;
    }

    public CategoryReducedDTO(){

    }
}
