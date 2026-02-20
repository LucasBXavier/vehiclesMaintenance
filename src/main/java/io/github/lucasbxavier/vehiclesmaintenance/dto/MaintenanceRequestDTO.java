package io.github.lucasbxavier.vehiclesmaintenance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MaintenanceRequestDTO {

    @NotNull
    @NotBlank
    private String vehiclePlate;

    private String description;

    @NotNull
    @NotBlank
    private String maintenanceType;

    @NotNull
    @NotBlank
    private String maintenanceStatus;

    @NotNull
    @NotBlank
    private String scheduledDate;

    @NotNull
    @NotBlank
    private String completedDate;

    @NotNull
    @NotBlank
    private BigDecimal cost;
}
