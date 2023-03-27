package com.br.finance.mapper;

import com.br.finance.model.dto.BalanceDTO;
import com.br.finance.model.entity.BalanceModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class BalanceMapper {
    public BalanceModel mapper (final BalanceDTO dto){
        BalanceModel model = new BalanceModel();
        model.setIdBalance(dto.getIdBalance());
        model.setDescription(dto.getDescription());
        model.setAdditionDate(dto.getAdditionDate());
        model.setBalanceValue(dto.getBalanceValue());
        model.setIdCategory(dto.getIdCategory());
        model.setTypeBalance(dto.getTypeBalance());
        model.setTypePayment(dto.getTypePayment());
        model.setDateInclusion(LocalDateTime.now());
        model.setDateUpdate(Objects.isNull(dto.getDateUpdate()) ? null : LocalDateTime.now());

        return model;
    }
}
