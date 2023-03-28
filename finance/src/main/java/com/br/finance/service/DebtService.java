package com.br.finance.service;

import com.br.finance.model.dto.DebtDTO;
import com.br.finance.model.dto.DebtResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Debt service.
 */
@Component
public interface DebtService {

    /**
     * <h2>Method responsible for saving a new <b><i>Debt</i></b>.</h2>
     *
     * @param debtDTO the balance dto
     * @return {@link DebtDTO}
     */
    DebtResponseDTO saved(final DebtDTO debtDTO);

    /**
     * <h2>
     * Method responsible for retrieving all <b><i>Debts</i></b>.
     * </h2>
     */
    List<DebtDTO> findAll();


    /**
     * <h2>
     * Method responsible for retrieving debt by <b><i>idDebt</i></b>.
     * </h2>
     *
     * @param idDebt the id debt.
     * @return {@link DebtDTO}
     */
    DebtDTO findById(final Long idDebt);

    /**
     * <h2>
     * Method responsible for update debt by <b><i>idDebt</i></b>.
     * </h2>
     *
     * @param idDebt the id debt.
     * @param dto the dto debt.
     * @return {@link DebtDTO}
     */
    DebtDTO update(final Long idDebt, final DebtDTO dto);

    /**
     * <h2>
     * Method responsible for delete debt by <b><i>idDebt</i></b>.
     * </h2>
     *
     * @param idDebt the id debt.
     * @return {@link DebtDTO}
     */
    void delete(final Long idDebt);

}
