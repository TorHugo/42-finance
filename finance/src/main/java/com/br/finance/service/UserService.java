package com.br.finance.service;

import com.br.finance.model.dto.CategoryReducedDTO;
import com.br.finance.model.dto.DebtDTO;
import com.br.finance.model.dto.DebtResponseDTO;
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

    /**
     * <h2>
     * Method responsible for retrieving users by <b><i>idUser</i></b>.
     * </h2>
     *
     * @param idUser the id user.
     * @return {@link UserDTO}
     */
    UserDTO findById(final Long idUser);

    /**
     * <h2>Method responsible for saving a new <b><i>User</i></b>.</h2>
     *
     * @param userDTO the user dto
     * @return {@link UserDTO}
     */
    UserDTO saved(final UserDTO userDTO);

    /**
     * <h2>
     * Method responsible for update user by <b><i>idUser</i></b>.
     * </h2>
     *
     * @param idUser the id user.
     * @param dto the dto user.
     * @return {@link UserDTO}
     */
    UserDTO update(final Long idUser, final UserDTO dto);


    /**
     * <h2>
     * Method responsible for delete user by <b><i>idUser</i></b>.
     * </h2>
     *
     * @param idUser the id debt.
     */
    void delete(final Long idUser);

}
