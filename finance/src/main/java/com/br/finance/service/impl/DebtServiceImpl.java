package com.br.finance.service.impl;

import com.br.finance.mapper.DebtMapper;
import com.br.finance.model.dto.DebtDTO;
import com.br.finance.model.entity.DebtModel;
import com.br.finance.repository.DebtRepository;
import com.br.finance.service.DebtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class DebtServiceImpl implements DebtService {

    @Autowired
    private DebtRepository repository;

    @Autowired
    private DebtMapper mapper;

    @Override
    public DebtDTO saved(DebtDTO debtDTO) {
        log.info("[1] - Mapping debt.");
        final DebtModel model = mapper.mapper(debtDTO);
        log.info("[2] - Saving debt in the database.");
        repository.save(model);
        return new DebtDTO(model);
    }
}
