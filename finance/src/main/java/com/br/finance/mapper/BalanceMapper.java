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

    public BalanceModel mapper(final BalanceModel recuperedBalance, final BalanceDTO dto) {
        BalanceModel model = new BalanceModel();
        model.setIdBalance(Objects.isNull(dto.getIdBalance()) ? recuperedBalance.getIdBalance() : dto.getIdBalance());
        model.setDescription(Objects.isNull(dto.getDescription()) ? recuperedBalance.getDescription() : dto.getDescription());
        model.setAdditionDate(Objects.isNull(dto.getAdditionDate()) ? recuperedBalance.getAdditionDate() : dto.getAdditionDate());
        model.setBalanceValue(Objects.isNull(dto.getBalanceValue()) ? recuperedBalance.getBalanceValue() : dto.getBalanceValue());
        model.setIdCategory(Objects.isNull(dto.getIdCategory()) ? recuperedBalance.getIdCategory() : dto.getIdCategory());
        model.setTypeBalance(Objects.isNull(dto.getTypeBalance()) ? recuperedBalance.getTypeBalance() : dto.getTypeBalance());
        model.setTypePayment(Objects.isNull(dto.getTypePayment()) ? recuperedBalance.getTypePayment() : dto.getTypePayment());
        model.setDateInclusion(Objects.isNull(dto.getDateInclusion()) ? recuperedBalance.getDateInclusion() : dto.getDateInclusion());
        model.setDateUpdate(LocalDateTime.now());

        return model;
    }
}
