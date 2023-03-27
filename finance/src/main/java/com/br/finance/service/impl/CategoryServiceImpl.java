package com.br.finance.service.impl;

import com.br.finance.exception.impl.DataBaseException;
import com.br.finance.mapper.CategoryMapper;
import com.br.finance.model.dto.CategoryDTO;
import com.br.finance.model.dto.CategoryResponseDTO;
import com.br.finance.model.entity.BalanceModel;
import com.br.finance.model.entity.CategoryModel;
import com.br.finance.repository.BalanceRepository;
import com.br.finance.repository.CategoryRepository;
import com.br.finance.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public CategoryResponseDTO saved(final CategoryDTO dto) {
        log.info("[1] - Validing category existing. {}", dto.getName());
        if (Objects.equals(validatitionCategoryByName(dto.getName()), Boolean.TRUE))
            throw new DataBaseException("Category is existing.");

        log.info("[2] - Mapping for categoryModel.");
        CategoryModel model = mapper.mapper(dto);

        log.info("[3] - Saving category in the database.");
        repository.save(model);
        return new CategoryResponseDTO(model);
    }


    @Override
    public CategoryResponseDTO findById(final Long idCategory) {
        log.info("[1] - Search category in the database. idCategory: {}", idCategory);
        CategoryModel model = repository.findById(idCategory)
                .orElseThrow(() -> new DataBaseException("Entity not found!"));

        log.info("[2] - Search all balances in the database.");
        List<BalanceModel> lsBalance = balanceRepository.findByIdCategory(idCategory);
        model.setLsBalance(lsBalance);

        calcTotalSpend(lsBalance);
        return new CategoryResponseDTO(model);
    }

    private Boolean validatitionCategoryByName(final String categoryName){
        Optional<CategoryModel> optCategory = repository.findByName(categoryName);
        if (optCategory.isPresent())
            return Boolean.TRUE;
        return Boolean.FALSE;
    }

    private BigDecimal calcTotalSpend(final List<BalanceModel> lsBalance){
        BigDecimal total = null;
        List<BigDecimal> lsBigDecimal = new ArrayList<BigDecimal>();

        lsBalance.stream().forEach(balance -> {
            lsBigDecimal.add(balance.getBalanceValue());
        });

        for (BigDecimal valor : lsBigDecimal) {
            total = total.add(valor);
        }

        return total;
    }
}