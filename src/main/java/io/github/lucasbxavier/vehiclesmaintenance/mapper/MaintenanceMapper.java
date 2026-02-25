package io.github.lucasbxavier.vehiclesmaintenance.mapper;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceType;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MaintenanceMapper {

    public static Maintenance toEntity(MaintenanceRequestDTO dto) {
        Maintenance maintenance = new Maintenance();

        maintenance.setVehiclePlate(dto.getVehiclePlate());
        maintenance.setDescription(dto.getDescription());
        maintenance.setMaintenanceType(MaintenanceType.valueOf(dto.getMaintenanceType()));
        maintenance.setStatus(MaintenanceStatus.valueOf(dto.getMaintenanceStatus()));
        maintenance.setScheduledDate(LocalDate.parse(dto.getScheduledDate()));
        maintenance.setCompletedDate(LocalDate.parse(dto.getCompletedDate()));
        maintenance.setCost(dto.getCost());

        return maintenance;
    }

    public MaintenanceResponseDTO toResponse(Maintenance entity) {
        return new MaintenanceResponseDTO(
                entity.getId(),
                entity.getVehiclePlate(),
                entity.getDescription(),
                entity.getMaintenanceType(),
                entity.getStatus(),
                entity.getScheduledDate(),
                entity.getCompletedDate(),
                entity.getCost(),
                entity.getCreatedAt()
        );
    }

    public static void updateEntity(Maintenance entity, MaintenanceRequestDTO dto) {
        entity.setVehiclePlate(dto.getVehiclePlate());
        entity.setDescription(dto.getDescription());
        entity.setMaintenanceType(MaintenanceType.valueOf(dto.getMaintenanceType()));
        entity.setScheduledDate(LocalDate.parse(dto.getScheduledDate()));
        entity.setCompletedDate(LocalDate.parse(dto.getCompletedDate()));
        entity.setCost(dto.getCost());
    }
}
