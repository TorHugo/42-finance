package com.br.finance.service;

import com.br.finance.model.dto.BalanceDTO;
import com.br.finance.model.dto.BalanceResponseDTO;
import com.br.finance.model.dto.CategoryDTO;
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
     * Method responsible for retrieving all <b><i>balances</i></b>.
     * </h2>
     *
     * @return {@link BalanceResponseDTO}
     */
    BalanceResponseDTO findAll();
    /**
     * <h2>
     * Method responsible for retrieving balacne by <b><i>idBalance</i></b>.
     * </h2>
     *
     * @param idBalance
     * @return {@link BalanceDTO}
     */
    BalanceDTO findById(final Long idBalance);
    /**
     * <h2>
     * Method responsible for updateting  <b><i>Balance</i></b>.
     * </h2>
     *
     * @param idBalance
     * @param balanceDTO
     * @return {@link BalanceDTO}
     */
    BalanceDTO update(final Long idBalance, final BalanceDTO balanceDTO);
    /**
     * <h2>
     * Method responsible for deleting  <b><i>balances</i></b>.
     * </h2>
     *
     * @param idBalance
     */
    void delete(final Long idBalance);
}
