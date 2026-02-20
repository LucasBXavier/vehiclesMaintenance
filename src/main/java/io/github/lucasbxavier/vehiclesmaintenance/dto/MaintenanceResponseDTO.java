package io.github.lucasbxavier.vehiclesmaintenance.dto;

import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class MaintenanceResponseDTO {

    private UUID id;
    private String vehiclePlate;
    private String description;
    private MaintenanceType maintenanceType;
    private MaintenanceStatus status;
    private LocalDate scheduledDate;
    private LocalDate completedDate;
    private BigDecimal cost;
    private LocalDateTime createdAt;

    public MaintenanceResponseDTO(UUID id, String vehiclePlate, String description, MaintenanceType maintenanceType, MaintenanceStatus status, LocalDate scheduledDate, LocalDate completedDate, BigDecimal cost, LocalDateTime createdAt) {
    }
}
