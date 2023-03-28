package com.br.finance.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_debt")
public class DebtModel extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_debt")
    private Long id;
    private String name;
    private BigDecimal debtAmount;
    private Float monthInterest;
    private LocalDate dateDue;
    private LocalDateTime dateInclusion;
    private LocalDateTime dateUpdate;
}
