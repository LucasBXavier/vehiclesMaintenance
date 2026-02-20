package io.github.lucasbxavier.vehiclesmaintenance.domain.entities;

import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "maintenances")
public class Maintenance {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String vehiclePlate;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaintenanceType maintenanceType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaintenanceStatus status;

    @Column(nullable = false)
    private LocalDate scheduledDate;

    private LocalDate completedDate;

    private BigDecimal cost;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
