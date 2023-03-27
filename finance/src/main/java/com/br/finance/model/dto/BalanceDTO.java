package com.br.finance.model.dto;

import com.br.finance.model.entity.BalanceModel;
import com.br.finance.model.entity.CategoryModel;
import com.br.finance.model.enums.TypeBalance;
import com.br.finance.model.enums.TypePayment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BalanceDTO {

    private Long idBalance;
    private String description;
    private BigDecimal balanceValue;
    private LocalDate additionDate;
    private Long idCategory;
    private TypeBalance typeBalance;
    private TypePayment typePayment;
    @JsonIgnore
    private LocalDateTime dateInclusion;
    @JsonIgnore
    private LocalDateTime dateUpdate;

    public BalanceDTO(BalanceModel model){
        this.idBalance = model.getIdBalance();
        this.description = model.getDescription();
        this.additionDate = model.getAdditionDate();
        this.idCategory = model.getIdCategory();
        this.balanceValue = model.getBalanceValue();
        this.typeBalance = model.getTypeBalance();
        this.typePayment = model.getTypePayment();
        this.dateInclusion = model.getDateInclusion();
        this.dateUpdate = model.getDateUpdate();
    }

    public BalanceDTO(Long idBalance, String description, BigDecimal balanceValue, LocalDate additionDate, Long idCategory, TypeBalance typeBalance, TypePayment typePayment, LocalDateTime dateInclusion, LocalDateTime dateUpdate) {
        this.idBalance = idBalance;
        this.description = description;
        this.balanceValue = balanceValue;
        this.additionDate = additionDate;
        this.idCategory = idCategory;
        this.typeBalance = typeBalance;
        this.typePayment = typePayment;
        this.dateInclusion = dateInclusion;
        this.dateUpdate = dateUpdate;
    }

    public BalanceDTO(){    }
}
