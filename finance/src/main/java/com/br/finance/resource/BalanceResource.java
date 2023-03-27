package com.br.finance.resource;

import com.br.finance.model.dto.BalanceDTO;
import com.br.finance.model.dto.CategoryDTO;
import com.br.finance.model.dto.CategoryResponseDTO;
import com.br.finance.service.BalanceService;
import com.br.finance.service.CategoryService;
import com.br.finance.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/balance")
public class BalanceResource {

    @Autowired
    private BalanceService service;

    @Autowired
    private ResponseUtils response;

    @PostMapping
    public ResponseEntity<BalanceDTO> createdBalance(
            @RequestBody final BalanceDTO dto) {
        BalanceDTO balanceDTO = service.saved(dto);
        return ResponseEntity.status(response.created).body(balanceDTO);
    }
}
