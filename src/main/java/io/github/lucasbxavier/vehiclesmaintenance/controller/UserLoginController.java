package io.github.lucasbxavier.vehiclesmaintenance.controller;

import io.github.lucasbxavier.vehiclesmaintenance.dto.LoginRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.UserRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.service.AuthService;
import io.github.lucasbxavier.vehiclesmaintenance.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
@AllArgsConstructor
public class UserLoginController {

    private UserService userService;
    private AuthService authService;

    @Operation(
            summary = "Criar usuário",
            description = "Cria um novo usuário para acessar o sistema."
    )
    @PostMapping("/criarUsuario")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDTO user) {
        userService.createUser(user);
        return ResponseEntity.ok().body("Usuário criado com sucesso");
    }

    @Operation(
            summary = "Login de usuário",
            description = "Autentica um usuário com email e senha para acessar o sistema."
    )
    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO user) {
        authService.authenticate(user);
        return ResponseEntity.ok().body("Login realizado com sucesso");
    }

        @Operation(
                summary = "Buscar usuário por email",
                description = "Busca um usuário específico através do email fornecido."
        )
    @GetMapping("/{email}")
    public ResponseEntity<?> find(@PathVariable String email) {
        return ResponseEntity.ok().body(userService.findUser(email));
    }
}
