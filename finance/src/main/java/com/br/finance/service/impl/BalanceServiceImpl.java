package com.br.finance.service.impl;

import com.br.finance.mapper.BalanceMapper;
import com.br.finance.model.dto.BalanceDTO;
import com.br.finance.model.entity.BalanceModel;
import com.br.finance.repository.BalanceRepository;
import com.br.finance.service.BalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private BalanceMapper mapper;

    @Override
    public BalanceDTO saved(BalanceDTO balanceDTO) {
        log.info("[1] - Mapping balance.");
        final BalanceModel model = mapper.mapper(balanceDTO);
        log.info("[2] - Saving balance in the database.");
        balanceRepository.save(model);
        return new BalanceDTO(model);
    }
}
