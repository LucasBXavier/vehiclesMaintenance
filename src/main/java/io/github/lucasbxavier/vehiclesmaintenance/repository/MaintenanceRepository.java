package io.github.lucasbxavier.vehiclesmaintenance.repository;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID> {

    List<Maintenance> findByStatus(MaintenanceStatus status);
    List<Maintenance> findByVehiclePlate(String vehiclePlate);
}
