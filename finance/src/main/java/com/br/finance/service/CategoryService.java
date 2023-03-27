package com.br.finance.service;

import com.br.finance.model.dto.CategoryDTO;
import com.br.finance.model.dto.CategoryReducedDTO;
import com.br.finance.model.dto.CategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Category service.
 */
@Component
public interface CategoryService {

    /**
     * <h2>Method responsible for saving a new <b><i>Category</i></b>.</h2>
     *
     * @param categoryDTO the category dto
     * @return {@link CategoryResponseDTO}
     */
    CategoryResponseDTO saved (final CategoryDTO categoryDTO);

    /**
     * <h2>
     * Method responsible for retrieving category by <b><i>idCategory</i></b>.
     * </h2>
     *
     * @param idCategory the id category.
     * @return {@link CategoryResponseDTO}
     */
    CategoryResponseDTO findById(final Long idCategory);

    /**
     * <h2>
     * Method responsible for retrieving all <b><i>categories</i></b>.
     * </h2>
     *
     * @return {@link CategoryReducedDTO}
     */
    List<CategoryReducedDTO> findByAll();
}
