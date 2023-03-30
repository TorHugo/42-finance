package com.br.finance.service.impl;

import com.br.finance.model.dto.UserDTO;
import com.br.finance.model.entity.UserModel;
import com.br.finance.repository.UserRepository;
import com.br.finance.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserDTO> findAll() {
        log.info("[1] - Search all debts in the database");
        List<UserModel> lsUsers = repository.findAll();
        return lsUsers.stream().map(u -> new UserDTO(u)).toList();
    }
}
