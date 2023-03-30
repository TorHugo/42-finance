package com.br.finance.model.dto;

import com.br.finance.model.entity.BalanceModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BalanceResponseDTO {
    private BigDecimal totalEntry;
    private BigDecimal totalExit;
    private List<BalanceModel> lsBalance;
}
