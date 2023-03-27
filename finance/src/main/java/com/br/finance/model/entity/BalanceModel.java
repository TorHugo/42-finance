package com.br.finance.model.entity;

import com.br.finance.model.enums.TypeBalance;
import com.br.finance.model.enums.TypePayment;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_balance")
public class BalanceModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_balance")
    private Long idBalance;
    private String description;
    @Positive
    private BigDecimal balanceValue;
    private LocalDate additionDate;

    @Column(name="id_category")
    private Long idCategory;

    private TypeBalance typeBalance;
    private TypePayment typePayment;
}
