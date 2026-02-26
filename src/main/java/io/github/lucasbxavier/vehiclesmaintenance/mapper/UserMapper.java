package io.github.lucasbxavier.vehiclesmaintenance.mapper;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.User;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.UserRole;
import io.github.lucasbxavier.vehiclesmaintenance.dto.UserRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.UserResponseDTO;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public static User toEntity(UserRequestDTO dto, String passwordHash) {
        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordHash);
        user.setName(dto.getName());
        user.setRole(UserRole.valueOf(dto.getRole()));

        return user;
    }

    public static UserResponseDTO toResponse(User entity) {
        UserRequestDTO dto = new UserRequestDTO();

        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setName(entity.getName());
        dto.setRole(entity.getRole().toString());

        return null;
    }

    public static void updateEntity(User entity, UserRequestDTO dto) {
        entity.setUsername(dto.getUsername());
        entity.setName(dto.getName());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
    }
}
