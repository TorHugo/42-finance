package com.br.finance.service;

import com.br.finance.model.dto.BalanceDTO;
import org.springframework.stereotype.Component;

/**
 * The interface Balance service.
 */
@Component
public interface BalanceService {
    /**
     * <h2>Method responsible for saving a new <b><i>Balance</i></b>.</h2>
     *
     * @param categoryDTO the category dto
     * @return {@link BalanceDTO}
     */
    BalanceDTO saved (final BalanceDTO balanceDTO);
}