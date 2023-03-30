package com.br.finance.service.impl;

import com.br.finance.exception.impl.DataBaseException;
import com.br.finance.mapper.BalanceMapper;
import com.br.finance.model.dto.BalanceDTO;
import com.br.finance.model.dto.BalanceResponseDTO;
import com.br.finance.model.dto.CategoryResponseDTO;
import com.br.finance.model.entity.BalanceModel;
import com.br.finance.model.entity.CategoryModel;
import com.br.finance.model.enums.TypeBalance;
import com.br.finance.repository.BalanceRepository;
import com.br.finance.repository.CategoryRepository;
import com.br.finance.service.BalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private BalanceRepository repository;

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
        repository.save(model);
        return new BalanceDTO(model);
    }

    @Override
    public BalanceResponseDTO findAll() {
        BalanceResponseDTO balanceResponseDTO = new BalanceResponseDTO();
        log.info("[1] - Search all balances in the database.");
        final List<BalanceModel> lsBalance = repository.findAll();
        balanceResponseDTO.setLsBalance(lsBalance);
        log.info("[2] - Calculator total of balances.");
        final HashMap<String, BigDecimal> totalBalanceValue = calculatorOfBalance(lsBalance);
        balanceResponseDTO.setTotalEntry(totalBalanceValue.get("totalEntry"));
        balanceResponseDTO.setTotalExit(totalBalanceValue.get("totalExit"));
        return balanceResponseDTO;
    }

    @Override
    public BalanceDTO findById(final Long idBalance) {
        log.info("[1] - Search balance in the database. idBalance: {}", idBalance);
        BalanceModel model = repository.findById(idBalance)
                .orElseThrow(() -> new DataBaseException("Entity not found!"));
        return new BalanceDTO(model);
    }

    private Boolean validatitionCategoryById(final Long idCategory){
        final Optional<CategoryModel> optCategory = categoryRepository.findById(idCategory);
        if (optCategory.isPresent())
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    private HashMap<String, BigDecimal> calculatorOfBalance(final List<BalanceModel> lsBalance){
        HashMap<String, BigDecimal> mapBalance = new HashMap<>();
        List<BigDecimal> lsValuesPayIn = new ArrayList<>();
        List<BigDecimal> lsValuesPayOut = new ArrayList<>();
        BigDecimal totalValuePayIn = BigDecimal.ZERO;
        BigDecimal totalValuePayOut = BigDecimal.ZERO;

        lsBalance.forEach(balance -> {
            if (Objects.equals(balance.getTypeBalance(), TypeBalance.PAYIN))
                lsValuesPayIn.add(balance.getBalanceValue());
            else
                lsValuesPayOut.add(balance.getBalanceValue());
        });

        for (BigDecimal valor : lsValuesPayIn) {
            totalValuePayIn = totalValuePayIn.add(valor);
        }
        mapBalance.put("totalEntry", totalValuePayIn);

        for (BigDecimal valor : lsValuesPayOut) {
            totalValuePayOut = totalValuePayOut.add(valor);
        }
        mapBalance.put("totalExit", totalValuePayOut);
        return mapBalance;
    }
}
