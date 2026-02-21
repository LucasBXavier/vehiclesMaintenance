package io.github.lucasbxavier.vehiclesmaintenance.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceRequestDTO {

    @NotNull
    @NotBlank
    public String vehiclePlate;

    public String description;

    @NotNull
    @NotBlank
    public String maintenanceType;

    @NotNull
    @NotBlank
    public String maintenanceStatus;

    @NotNull
    @NotBlank
    public String scheduledDate;

    @NotNull
    @NotBlank
    public String completedDate;

    @NotNull
    @NotBlank
    public BigDecimal cost;
}
