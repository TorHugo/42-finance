package com.br.finance.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_user")
public class UserModel extends BaseModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    private String name;
    private String email;
    private String password;
    private String telephone;
}
