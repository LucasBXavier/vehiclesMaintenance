package io.github.lucasbxavier.vehiclesmaintenance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MaintenanceRequestDTO {

    @NotNull
    @NotBlank
    private String vehiclePlate;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String maintenanceType;

    @NotNull
    @NotBlank
    private String scheduledDate;
}
