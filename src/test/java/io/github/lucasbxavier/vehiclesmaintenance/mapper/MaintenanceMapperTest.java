package io.github.lucasbxavier.vehiclesmaintenance.mapper;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceType;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceResponseDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceMapperTest {

    @Test
    void shouldMapRequestDtoToEntity() {
        MaintenanceRequestDTO dto = new MaintenanceRequestDTO(
                "ABC1234",
                "Troca de óleo",
                "PNEU",
                "AGENDADO",
                "2026-02-20",
                "2026-02-25",
                BigDecimal.valueOf(150)
        );

        Maintenance entity = MaintenanceMapper.toEntity(dto);

        assertEquals("ABC1234", entity.getVehiclePlate());
        assertEquals("Troca de óleo", entity.getDescription());
        assertEquals(MaintenanceType.PNEU, entity.getMaintenanceType());
        assertEquals(MaintenanceStatus.AGENDADO, entity.getStatus());
        assertEquals(LocalDate.parse("2026-02-20"), entity.getScheduledDate());
        assertEquals(LocalDate.parse("2026-02-25"), entity.getCompletedDate());
        assertEquals(BigDecimal.valueOf(150), entity.getCost());
    }

    @Test
    void shouldMapEntityToResponseDto() {
        Maintenance entity = new Maintenance();
        UUID id = UUID.randomUUID();

        entity.setId(id);
        entity.setVehiclePlate("XYZ9876");
        entity.setDescription("Revisão geral");
        entity.setMaintenanceType(MaintenanceType.PNEU);
        entity.setStatus(MaintenanceStatus.AGENDADO);
        entity.setScheduledDate(LocalDate.parse("2026-01-10"));
        entity.setCompletedDate(LocalDate.parse("2026-01-12"));
        entity.setCost(BigDecimal.valueOf(900));
        entity.setCreatedAt(LocalDateTime.now());

        MaintenanceMapper mapper = new MaintenanceMapper();
        MaintenanceResponseDTO response = mapper.toResponse(entity);

        assertEquals(id, response.getId());
        assertEquals("XYZ9876", response.getVehiclePlate());
        assertEquals("Revisão geral", response.getDescription());
        assertEquals(MaintenanceType.PNEU, response.getMaintenanceType());
        assertEquals(MaintenanceStatus.AGENDADO, response.getStatus());
        assertEquals(LocalDate.parse("2026-01-10"), response.getScheduledDate());
        assertEquals(LocalDate.parse("2026-01-12"), response.getCompletedDate());
        assertEquals(BigDecimal.valueOf(900), response.getCost());
        assertNotNull(response.getCreatedAt());
    }

    @Test
    void shouldUpdateEntityFromRequestDto() {
        Maintenance entity = new Maintenance();
        entity.setDescription("Antiga");
        entity.setMaintenanceType(MaintenanceType.PNEU);
        entity.setScheduledDate(LocalDate.parse("2026-01-01"));
        entity.setCompletedDate(LocalDate.parse("2026-01-02"));

        MaintenanceRequestDTO dto = new MaintenanceRequestDTO(
                "AAA1111",
                "Nova descrição",
                "PNEU",
                "AGENDADO",
                "2026-03-01",
                "2026-03-05",
                BigDecimal.valueOf(300)
        );

        MaintenanceMapper.updateEntity(entity, dto);

        assertEquals("Nova descrição", entity.getDescription());
        assertEquals(MaintenanceType.PNEU, entity.getMaintenanceType());
        assertEquals(LocalDate.parse("2026-03-01"), entity.getScheduledDate());
        assertEquals(LocalDate.parse("2026-03-05"), entity.getCompletedDate());
    }

}