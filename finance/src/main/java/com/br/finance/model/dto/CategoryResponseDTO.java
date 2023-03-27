package com.br.finance.model.dto;

import com.br.finance.model.entity.BalanceModel;
import com.br.finance.model.entity.CategoryModel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
public class CategoryResponseDTO extends CategoryDTO{
    private BigDecimal totalSpend;
    private List<BalanceModel> lsBalance;

    public CategoryResponseDTO(CategoryModel model) {
        super(model);
        this.totalSpend = model.getTotalSpend();
        this.lsBalance = model.getLsBalance();
    }
}
