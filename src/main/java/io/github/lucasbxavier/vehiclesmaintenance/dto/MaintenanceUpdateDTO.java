package io.github.lucasbxavier.vehiclesmaintenance.dto;

import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceUpdateDTO {

    private LocalDate scheduledDate;
    private LocalDate completedDate;
    private BigDecimal cost;
    private MaintenanceStatus status;
}
