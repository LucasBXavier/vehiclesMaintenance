package io.github.lucasbxavier.vehiclesmaintenance.service;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.User;
import io.github.lucasbxavier.vehiclesmaintenance.dto.UserRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.mapper.UserMapper;
import io.github.lucasbxavier.vehiclesmaintenance.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository repository;
    private UserMapper mapper;

    public void createUser(UserRequestDTO dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("E-mail já cadastrado");
        } else {
            var passwordHash = passwordEncoder.encode(dto.getPassword());
            var user = mapper.toEntity(dto, passwordHash);
            repository.save(user);
        }
    }

    public Optional<User> findUser(String email) {
        var user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
         return this.repository.findByEmail(email);
    }
}
