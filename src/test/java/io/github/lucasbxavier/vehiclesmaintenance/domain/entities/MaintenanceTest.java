package io.github.lucasbxavier.vehiclesmaintenance.domain.entities;

import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceTest {

    @Test
    void shouldSetCreatedAtOnPrePersist() {
        Maintenance maintenance = new Maintenance();

        maintenance.onCreate();

        assertNotNull(maintenance.getCreatedAt());
        assertTrue(maintenance.getCreatedAt().isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    void shouldCreateMaintenanceWithValidData() {
        Maintenance maintenance = new Maintenance();

        UUID id = UUID.randomUUID();
        LocalDate scheduledDate = LocalDate.now();

        maintenance.setId(id);
        maintenance.setVehiclePlate("ABC-1234");
        maintenance.setDescription("Troca de óleo");
        maintenance.setMaintenanceType(MaintenanceType.OIL_CHANGE);
        maintenance.setStatus(MaintenanceStatus.IN_PROGRESS);
        maintenance.setScheduledDate(scheduledDate);
        maintenance.setCost(BigDecimal.valueOf(250.00));

        assertEquals(id, maintenance.getId());
        assertEquals("ABC-1234", maintenance.getVehiclePlate());
        assertEquals("Troca de óleo", maintenance.getDescription());
        assertEquals(MaintenanceType.OIL_CHANGE, maintenance.getMaintenanceType());
        assertEquals(MaintenanceStatus.IN_PROGRESS, maintenance.getStatus());
        assertEquals(scheduledDate, maintenance.getScheduledDate());
        assertEquals(BigDecimal.valueOf(250.00), maintenance.getCost());
    }

    @Test
    void shouldAllowCompletedDateToBeNull() {
        Maintenance maintenance = new Maintenance();

        maintenance.setCompletedDate(null);

        assertNull(maintenance.getCompletedDate());
    }

    @Test
    void shouldUpdateStatusAndCompletedDate() {
        Maintenance maintenance = new Maintenance();

        LocalDate completedDate = LocalDate.now();

        maintenance.setStatus(MaintenanceStatus.COMPLETED);
        maintenance.setCompletedDate(completedDate);

        assertEquals(MaintenanceStatus.COMPLETED, maintenance.getStatus());
        assertEquals(completedDate, maintenance.getCompletedDate());
    }
}