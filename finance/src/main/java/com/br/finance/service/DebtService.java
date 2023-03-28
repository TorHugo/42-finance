package com.br.finance.service;

import com.br.finance.model.dto.DebtDTO;
import org.springframework.stereotype.Component;
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
    DebtDTO saved(final DebtDTO debtDTO);
}
