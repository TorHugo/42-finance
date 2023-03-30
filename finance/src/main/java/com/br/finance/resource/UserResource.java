package com.br.finance.resource;

import com.br.finance.model.dto.UserDTO;
import com.br.finance.model.entity.UserModel;
import com.br.finance.repository.UserRepository;
import com.br.finance.service.UserService;
import com.br.finance.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private ResponseUtils response;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = service.findAll();
        return ResponseEntity.status(response.successful).body(users);
    }

}
