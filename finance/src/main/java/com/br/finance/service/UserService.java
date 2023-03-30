package com.br.finance.service;

import com.br.finance.model.dto.CategoryReducedDTO;
import com.br.finance.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    /**
     * <h2>
     * Method responsible for retrieving all <b><i>users</i></b>.
     * </h2>
     *
     * @return {@link UserDTO}
     */
    List<UserDTO> findAll();
}
