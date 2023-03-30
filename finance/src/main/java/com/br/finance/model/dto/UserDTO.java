package com.br.finance.model.dto;

import com.br.finance.model.entity.UserModel;
import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String telephone;

    public UserDTO(UserModel model){
        this.id = model.getId();
        this.name = model.getName();
        this.email = model.getEmail();
        this.password = model.getPassword();
        this.telephone = model.getTelephone();
    }

    public UserDTO(Long id, String name, String email, String password, String telephone){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
    }

    public UserDTO(){

    }

}
