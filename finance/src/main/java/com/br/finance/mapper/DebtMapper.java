package com.br.finance.mapper;

import com.br.finance.model.dto.DebtDTO;
import com.br.finance.model.entity.DebtModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class DebtMapper {

    public DebtModel mapper(final DebtDTO dto){
        DebtModel model = new DebtModel();
        model.setId(dto.getId());
        model.setName(dto.getName());
        model.setDebtAmount(dto.getDebtAmount());
        model.setMonthInterest(dto.getMonthInterest());
        model.setDateDue(dto.getDateDue());
        model.setDateInclusion(LocalDateTime.now());
        model.setDateUpdate(Objects.isNull(dto.getDateUpdate()) ? null : LocalDateTime.now());

        return model;
    }
}
