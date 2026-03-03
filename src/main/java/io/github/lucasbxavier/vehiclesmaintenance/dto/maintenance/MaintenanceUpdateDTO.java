package io.github.lucasbxavier.vehiclesmaintenance.dto.maintenance;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate scheduledDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate completedDate;
    private BigDecimal cost;
    private MaintenanceStatus status;
}
