package com.br.finance.resource;

import com.br.finance.model.dto.DebtDTO;
import com.br.finance.model.dto.DebtResponseDTO;
import com.br.finance.service.DebtService;
import com.br.finance.util.ResponseUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/debts")
public class DebtResource {

    @Autowired
    private DebtService service;

    @Autowired
    private ResponseUtils response;

    @GetMapping
    public ResponseEntity<List<DebtDTO>> findAll(){
        List<DebtDTO> debts = service.findAll();
        return ResponseEntity.status(response.successful).body(debts);
    }

    @GetMapping("/{idDebt}")
    public ResponseEntity<DebtDTO> findById(@PathVariable Long idDebt){
        DebtDTO debt = service.findById(idDebt);
        return ResponseEntity.status(response.successful).body(debt);
    }

    @PostMapping
    public ResponseEntity<DebtResponseDTO> createdDebt(@RequestBody final DebtDTO dto){
        System.out.println(dto.toString());
        DebtResponseDTO debtReponseDTO = service.saved(dto);
        return ResponseEntity.status(response.created).body(debtReponseDTO);
    }

    @PutMapping("/{idDebt}")
    public ResponseEntity<DebtDTO> update(@PathVariable Long idDebt, @RequestBody DebtDTO dto){
        DebtDTO debt = service.update(idDebt, dto);
        return ResponseEntity.status(response.successful).body(dto);
    }

    @DeleteMapping("/{idDebt}")
    public ResponseEntity<Void> delete(@PathVariable Long idDebt){
        service.delete(idDebt);
        return ResponseEntity.status(response.noContent).build();
    }
}
