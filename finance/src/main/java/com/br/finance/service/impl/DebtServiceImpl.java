package com.br.finance.service.impl;

import com.br.finance.exception.impl.DataBaseException;
import com.br.finance.mapper.DebtMapper;
import com.br.finance.model.dto.DebtDTO;
import com.br.finance.model.dto.DebtResponseDTO;
import com.br.finance.model.entity.DebtModel;
import com.br.finance.repository.DebtRepository;
import com.br.finance.service.DebtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class DebtServiceImpl implements DebtService {

    @Autowired
    private DebtRepository repository;

    @Autowired
    private DebtMapper mapper;

    @Override
    @Transactional
    public DebtResponseDTO saved(DebtDTO debtDTO) {
        log.info("[1] - Mapping debt.");
        DebtModel model = mapper.mapper(debtDTO);
        log.info("[2] - Saving debt in the database.");
        repository.save(model);
        return new DebtResponseDTO(model);
    }

    @Override
    public List<DebtDTO> findAll() {
        log.info("[1] - Search all debts in the database");
        final List<DebtModel> lsDebts = repository.findAll();
        return lsDebts.stream().map(d -> new DebtDTO(d)).toList();
    }

    @Override
    public DebtDTO findById(Long idDebt) {
        log.info("[1] - Search debt in the database. idDebt: {}", idDebt);
        DebtModel model = repository.findById(idDebt).orElseThrow(() -> new DataBaseException("Entity not found!"));
        return new DebtDTO(model);
    }

    @Override
    @Transactional
    public DebtDTO update(Long idDebt, DebtDTO dto) {
        log.info("[1] - Search debt in the database. idDebt: {}", idDebt);
        DebtModel debt = repository.getReferenceById(idDebt);

        log.info("[2] - Mapping for debtModel.");
        DebtModel model = mapper.mapper(dto);

        log.info("[3] - Save debt in the database");
        repository.save(model);

        return new DebtDTO(model);
    }

    @Override
    @Transactional
    public void delete(Long idDebt) {
        log.info("[1] - Delete debt in the database by id. idDebt: {}", idDebt);
        repository.deleteById(idDebt);
    }

}
