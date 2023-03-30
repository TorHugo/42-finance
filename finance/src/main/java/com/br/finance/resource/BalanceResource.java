package com.br.finance.resource;

import com.br.finance.model.dto.BalanceDTO;
import com.br.finance.model.dto.BalanceResponseDTO;
import com.br.finance.service.BalanceService;
import com.br.finance.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/balances")
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

    @GetMapping
    public ResponseEntity<BalanceResponseDTO> findAll() {
        BalanceResponseDTO lsBalanceDTO = service.findAll();
        return ResponseEntity.status(response.created).body(lsBalanceDTO);
    }

    @GetMapping("/{idBalance}")
    public ResponseEntity<BalanceDTO> findAll(
            @PathVariable final Long idBalance) {
        BalanceDTO lsBalanceDTO = service.findById(idBalance);
        return ResponseEntity.status(response.created).body(lsBalanceDTO);
    }


}
