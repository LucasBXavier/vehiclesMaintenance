package io.github.lucasbxavier.vehiclesmaintenance.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class LoginRequestDTO {

    @NotNull
    private String email;
    @NotNull
    private String password;
}
