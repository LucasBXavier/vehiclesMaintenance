package io.github.lucasbxavier.vehiclesmaintenance.service;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.mapper.MaintenanceMapper;
import io.github.lucasbxavier.vehiclesmaintenance.repository.MaintenanceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;


@Log
@Service
@AllArgsConstructor
public class MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    private MaintenanceMapper mapper;


    public void createMaintenance(@RequestBody MaintenanceRequestDTO dto) {
        var manutencao = mapper.toEntity(dto);
        maintenanceRepository.save(manutencao);
    }

    public List<Maintenance> findAll() {
        return this.maintenanceRepository.findAll();
    }

    public Object findById(@PathVariable UUID id) {
        return this.maintenanceRepository.findById(id);
    }

    public void deleteMaintenance(UUID id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new EntityNotFoundException("Manutenção não encontrada");
        }

        maintenanceRepository.deleteById(id);
    }
}
