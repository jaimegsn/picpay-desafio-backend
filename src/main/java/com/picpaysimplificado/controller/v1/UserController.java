package com.picpaysimplificado.controller.v1;


import com.picpaysimplificado.domain.model.User;
import com.picpaysimplificado.dto.v1.UserDTO;
import com.picpaysimplificado.service.v1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        User user = userService.saveUser(userDTO);
        return ResponseEntity.ok().body(new UserDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }
}
