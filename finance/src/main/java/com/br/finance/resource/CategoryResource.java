package com.br.finance.resource;

import com.br.finance.model.dto.CategoryDTO;
import com.br.finance.model.dto.CategoryResponseDTO;
import com.br.finance.service.CategoryService;
import com.br.finance.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
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
}
