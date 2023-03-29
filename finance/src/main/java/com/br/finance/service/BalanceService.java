package com.br.finance.service;

import com.br.finance.model.dto.BalanceDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Balance service.
 */
@Component
public interface BalanceService {
    /**
     * <h2>Method responsible for saving a new <b><i>Balance</i></b>.</h2>
     *
     * @param balanceDTO the category dto
     * @return {@link BalanceDTO}
     */
    BalanceDTO saved (final BalanceDTO balanceDTO);
}
