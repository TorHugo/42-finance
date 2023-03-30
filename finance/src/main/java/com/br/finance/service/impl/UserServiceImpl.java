package com.br.finance.service.impl;

import com.br.finance.exception.impl.DataBaseException;
import com.br.finance.mapper.UserMapper;
import com.br.finance.model.dto.DebtDTO;
import com.br.finance.model.dto.DebtResponseDTO;
import com.br.finance.model.dto.UserDTO;
import com.br.finance.model.entity.DebtModel;
import com.br.finance.model.entity.UserModel;
import com.br.finance.repository.UserRepository;
import com.br.finance.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserDTO> findAll() {
        log.info("[1] - Search all debts in the database");
        List<UserModel> lsUsers = repository.findAll();
        return lsUsers.stream().map(u -> new UserDTO(u)).toList();
    }

    @Override
    public UserDTO findById(Long idUser) {
        log.info("[1] - Search user in the database. idUser: {}", idUser);
        UserModel model = repository.findById(idUser).
                orElseThrow(() -> new DataBaseException("Entity not found!"));
        return new UserDTO(model);
    }

    @Override
    public UserDTO saved(UserDTO userDTO) {
        log.info("[1] - Mapping user.");
        UserModel model = mapper.mapper(userDTO);
        log.info("[2] - Saving user in the database.");
        repository.save(model);
        return new UserDTO(model);
    }

}
