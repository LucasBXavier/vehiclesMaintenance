package io.github.lucasbxavier.vehiclesmaintenance.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceResponseDTO {

    public UUID id;
    public String vehiclePlate;
    public String description;
    public MaintenanceType maintenanceType;
    public MaintenanceStatus status;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public LocalDate scheduledDate;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public LocalDate completedDate;
    public BigDecimal cost;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    public LocalDateTime createdAt;
}
