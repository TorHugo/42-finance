package com.br.finance.model.dto;

import com.br.finance.model.entity.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String telephone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateInclusion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateUpdate;

    public UserDTO(UserModel model){
        this.id = model.getId();
        this.name = model.getName();
        this.email = model.getEmail();
        this.password = model.getPassword();
        this.telephone = model.getTelephone();
        this.dateUpdate = model.getDateUpdate();
        this.dateInclusion = model.getDateInclusion();
    }

    public UserDTO(Long id, String name, String email, String password, String telephone, LocalDateTime dateUpdate, LocalDateTime dateInclusion){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.dateUpdate = dateUpdate;
        this.dateInclusion = dateInclusion;
    }

    public UserDTO(){

    }

}
