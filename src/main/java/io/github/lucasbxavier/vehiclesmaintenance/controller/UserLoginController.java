package io.github.lucasbxavier.vehiclesmaintenance.controller;

import io.github.lucasbxavier.vehiclesmaintenance.dto.UserRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
@AllArgsConstructor
public class UserLoginController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO user) {
        userService.createUser(user);
        return ResponseEntity.ok().body("Usuário criado com sucesso");
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> login(@PathVariable String email) {
        return ResponseEntity.ok().body(userService.findUser(email));
    }
}
