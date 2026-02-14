package io.github.lucasbxavier.vehiclesmaintenance.repository;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, String> {

    List<Maintenance> findByStatus(MaintenanceStatus status);

    boolean existsByVehiclePlateAndStatus(String vehiclePlate, MaintenanceStatus status);
}
