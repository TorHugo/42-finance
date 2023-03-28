package com.br.finance.resource;

import com.br.finance.model.dto.DebtDTO;
import com.br.finance.service.DebtService;
import com.br.finance.util.ResponseUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/debts")
public class DebtResource {

    @Autowired
    private DebtService service;

    @Autowired
    private ResponseUtils response;

    @PostMapping
    public ResponseEntity<DebtDTO> createdDebt(@RequestBody final DebtDTO dto){
        DebtDTO debtDTO = service.saved(dto);
        return ResponseEntity.status(response.created).body(debtDTO);
    }
}
