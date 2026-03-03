package io.github.lucasbxavier.vehiclesmaintenance.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd/MM/yyyy")
    public String scheduledDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    public String completedDate;

    @NotNull
    @NotBlank
    public BigDecimal cost;
}
