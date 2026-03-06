package io.github.lucasbxavier.vehiclesmaintenance.controller;

import io.github.lucasbxavier.vehiclesmaintenance.dto.LoginRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.user.UserRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.service.LoginService;
import io.github.lucasbxavier.vehiclesmaintenance.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/login")
@AllArgsConstructor
public class UserLoginController {

    private UserService userService;
    private LoginService loginService;


    @Operation(
            summary = "Criar usuário",
            description = "Cria um novo usuário para acessar o sistema."
    )
    @PostMapping("/criarUsuario")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRequestDTO user) {
        userService.createUser(user);
        return ResponseEntity.ok().body("Usuário criado com sucesso");
    }

    @Operation(
            summary = "Login de usuário",
            description = "Autentica um usuário com email e senha para acessar o sistema."
    )
    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDTO user, HttpServletRequest request) {
        loginService.login(user, request);
        return ResponseEntity.ok(Map.of("message", "Login realizado com sucesso"));
    }
}
