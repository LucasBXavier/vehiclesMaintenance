package io.github.lucasbxavier.vehiclesmaintenance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank
    @NotNull
    public String username;
    @NotBlank
    @NotNull
    public String email;
    @NotBlank
    @NotNull
    public String password;
    @NotBlank
    @NotNull
    public String name;
    @NotBlank
    @NotNull
    public String role;
}
