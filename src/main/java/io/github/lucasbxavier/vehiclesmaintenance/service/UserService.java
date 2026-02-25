package io.github.lucasbxavier.vehiclesmaintenance.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.User;
import io.github.lucasbxavier.vehiclesmaintenance.dto.UserRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.mapper.UserMapper;
import io.github.lucasbxavier.vehiclesmaintenance.repository.UserRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;
    private UserMapper mapper;

    public void createUser(@RequestBody UserRequestDTO dto) {
        var user = repository.findByEmail(dto.getEmail());
        if (!user.isEmpty()) {
            throw new RuntimeException("E-mail já cadastrado");
        } else {
            var passwordHash = BCrypt.withDefaults().hashToString(12, dto.getPassword().toCharArray());
            dto.setPassword(passwordHash);
            repository.save(UserMapper.toEntity(dto));
        }
    }

    public Optional<User> findUser(@PathVariable String email) {
        var user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
         return this.repository.findByEmail(email);
    }
}
