package com.br.finance.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_category")
public class CategoryModel extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_category")
    private Long id;
    private String name;
    private String description;
    private BigDecimal monthlyBudget;
    private BigDecimal totalSpend;

    @OneToMany
    private List<BalanceModel> lsBalance = new ArrayList<>();
}
