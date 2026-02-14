package io.github.lucasbxavier.vehiclesmaintenance.dto;

import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class MaintenanceResponseDTO {

    private String id;
    private String vehiclePlate;
    private String description;
    private String status;
    private MaintenanceType maintenanceType;
    private BigDecimal cost;

    public MaintenanceResponseDTO(int id, String vehiclePlate, String description, MaintenanceType maintenanceType, MaintenanceStatus status, LocalDate scheduledDate, LocalDate completedDate, BigDecimal cost, LocalDateTime createdAt) {
    }
}
