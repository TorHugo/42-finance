package com.br.finance.model.dto;

import com.br.finance.model.entity.DebtModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DebtDTO {
    private Long id;
    private String name;
    private BigDecimal debtAmount;
    private Float monthInterest;
    private LocalDate dateDue;
    @JsonIgnore
    private LocalDateTime dateInclusion;

    @JsonIgnore
    private LocalDateTime dateUpdate;

    public DebtDTO(DebtModel model){
        this.id = model.getId();
        this.name = model.getName();
        this.debtAmount = model.getDebtAmount();
        this.monthInterest = model.getMonthInterest();
        this.dateDue = model.getDateDue();
        this.dateInclusion = model.getDateInclusion();
        this.dateUpdate = model.getDateUpdate();
    }

    public DebtDTO(Long id, String name, BigDecimal debtAmount, Float monthInterest, LocalDate dateDue, LocalDateTime dateInclusion, LocalDateTime dateUpdate) {
        this.id = id;
        this.name = name;
        this.debtAmount = debtAmount;
        this.monthInterest = monthInterest;
        this.dateDue = dateDue;
        this.dateInclusion = dateInclusion;
        this.dateUpdate = dateUpdate;
    }

    public DebtDTO(){

    }

}
