package com.br.finance.service;

import com.br.finance.model.dto.BalanceDTO;
import com.br.finance.model.dto.BalanceResponseDTO;
import com.br.finance.model.dto.CategoryReducedDTO;
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
    /**
     * <h2>
     * Method responsible for retrieving all <b><i>categories</i></b>.
     * </h2>
     *
     * @return {@link BalanceResponseDTO}
     */
    BalanceResponseDTO findAll();
    /**
     * <h2>
     * Method responsible for retrieving category by <b><i>idBalance</i></b>.
     * </h2>
     *
     * @param idBalance
     * @return {@link BalanceDTO}
     */
    BalanceDTO findById(final Long idBalance);
}
