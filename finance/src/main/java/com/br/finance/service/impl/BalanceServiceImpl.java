package com.br.finance.service.impl;

import com.br.finance.exception.impl.DataBaseException;
import com.br.finance.mapper.BalanceMapper;
import com.br.finance.model.dto.BalanceDTO;
import com.br.finance.model.entity.BalanceModel;
import com.br.finance.model.entity.CategoryModel;
import com.br.finance.repository.BalanceRepository;
import com.br.finance.repository.CategoryRepository;
import com.br.finance.service.BalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BalanceMapper mapper;

    @Override
    public BalanceDTO saved(BalanceDTO balanceDTO) {
        log.info("[1] - Validing category existing. {}", balanceDTO.getIdCategory());
        if (Objects.equals(validatitionCategoryById(balanceDTO.getIdCategory()), Boolean.FALSE))
            throw new DataBaseException("Category not found.");

        log.info("[2] - Mapping balance.");
        final BalanceModel model = mapper.mapper(balanceDTO);

        log.info("[3] - Saving balance in the database.");
        balanceRepository.save(model);
        return new BalanceDTO(model);
    }

    private Boolean validatitionCategoryById(final Long idCategory){
        final Optional<CategoryModel> optCategory = categoryRepository.findById(idCategory);
        if (optCategory.isPresent())
            return Boolean.TRUE;
        return Boolean.FALSE;
    }
}
