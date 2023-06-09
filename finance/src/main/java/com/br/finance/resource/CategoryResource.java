package com.br.finance.resource;

import com.br.finance.model.dto.CategoryDTO;
import com.br.finance.model.dto.CategoryReducedDTO;
import com.br.finance.model.dto.CategoryResponseDTO;
import com.br.finance.service.CategoryService;
import com.br.finance.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @Autowired
    private ResponseUtils response;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createdCategory(
            @RequestBody final CategoryDTO dto) {
        CategoryResponseDTO categoryResponseDTO = service.saved(dto);
        return ResponseEntity.status(response.created).body(categoryResponseDTO);
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<CategoryResponseDTO> findById(
             @PathVariable final Long idCategory){
        CategoryResponseDTO categoryResponseDTO = service.findById(idCategory);
        return ResponseEntity.status(response.created).body(categoryResponseDTO);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryReducedDTO>> findAll(){
        List<CategoryReducedDTO> lsCategoryResponse = service.findByAll();
        return ResponseEntity.status(response.created).body(lsCategoryResponse);
    }

    @PutMapping("/{idCategory}")
    public ResponseEntity<CategoryDTO> update(
            @RequestBody @Valid final CategoryDTO dto,
            @PathVariable final Long idCategory){

        CategoryDTO categoryDTO = service.update(idCategory, dto);
        return ResponseEntity.status(response.created).body(categoryDTO);
    }

    @DeleteMapping(value = "/{idCategory}")
    public ResponseEntity<CategoryDTO> delete(
            @PathVariable final Long idCategory){
        service.delete(idCategory);
        return ResponseEntity.status(response.noContent).build();
    }
}
