package com.br.finance.mapper;

import com.br.finance.model.dto.UserDTO;
import com.br.finance.model.entity.UserModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class UserMapper {

    public UserModel mapper(final UserDTO dto){
        UserModel model = new UserModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setPassword(dto.getPassword());
        model.setTelephone(dto.getTelephone());
        model.setDateInclusion(LocalDateTime.now());
        model.setDateUpdate(Objects.isNull(dto.getDateUpdate()) ? null : LocalDateTime.now());
        return model;
    }
}
