package io.github.lucasbxavier.vehiclesmaintenance.dto;

import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceType;
import io.github.lucasbxavier.vehiclesmaintenance.dto.maintenance.MaintenanceResponseDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceResponseDTOTest {

    @Test
    void shouldCreateMaintenanceResponseDTOWithAllFields() {
        UUID id = UUID.randomUUID();
        LocalDate scheduledDate = LocalDate.now();
        LocalDate completedDate = LocalDate.now().plusDays(1);
        LocalDateTime createdAt = LocalDateTime.now();

        MaintenanceResponseDTO dto = new MaintenanceResponseDTO(
                id,
                "ABC-1234",
                "Troca de óleo",
                MaintenanceType.FREIO,
                MaintenanceStatus.CANCELADO,
                scheduledDate,
                completedDate,
                BigDecimal.valueOf(350.00),
                createdAt
        );

        assertEquals(id, dto.getId());
        assertEquals("ABC-1234", dto.getVehiclePlate());
        assertEquals("Troca de óleo", dto.getDescription());
        assertEquals(MaintenanceType.FREIO, dto.getMaintenanceType());
        assertEquals(MaintenanceStatus.CANCELADO, dto.getStatus());
        assertEquals(scheduledDate, dto.getScheduledDate());
        assertEquals(completedDate, dto.getCompletedDate());
        assertEquals(BigDecimal.valueOf(350.00), dto.getCost());
        assertEquals(createdAt, dto.getCreatedAt());
    }

}