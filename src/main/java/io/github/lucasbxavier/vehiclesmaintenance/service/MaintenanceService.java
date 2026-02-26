package io.github.lucasbxavier.vehiclesmaintenance.service;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceStatusUpdateDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceUpdateDTO;
import io.github.lucasbxavier.vehiclesmaintenance.exception.BusinessRuleException;
import io.github.lucasbxavier.vehiclesmaintenance.exception.MaintenanceNotFoundException;
import io.github.lucasbxavier.vehiclesmaintenance.mapper.MaintenanceMapper;
import io.github.lucasbxavier.vehiclesmaintenance.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    private MaintenanceMapper mapper;


    public void createMaintenance(@RequestBody MaintenanceRequestDTO dto) {
        var manutencao = MaintenanceMapper.toEntity(dto);
        if (manutencao.getCompletedDate() != null &&
                manutencao.getCompletedDate().isBefore(manutencao.getScheduledDate())) {
            throw new BusinessRuleException("A data de conclusão não pode ser anterior à data agendada");
        }
        maintenanceRepository.save(manutencao);
    }

    public List<Maintenance> findAll() {
        var manutencoes = maintenanceRepository.findAll();
        if (maintenanceRepository.findAll().isEmpty()) {
            throw new MaintenanceNotFoundException("Nenhuma manutenção encontrada");
        }
        mapper.toResponse(manutencoes.getFirst());
        return manutencoes;
    }

    public Optional<Maintenance> findById(@PathVariable UUID id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new MaintenanceNotFoundException("Manutenção não encontrada");
        }
        return this.maintenanceRepository.findById(id);
    }

    public List<Maintenance> findByStatus(@PathVariable String status) {
        if (this.maintenanceRepository.findByStatus(MaintenanceStatus.valueOf(status)).isEmpty()) {
            throw new MaintenanceNotFoundException("Nenhuma manutenção encontrada com o status: " + status);
        }
        return this.maintenanceRepository.findByStatus(MaintenanceStatus.valueOf(status));
    }

    public List<Maintenance> findByPlate(@PathVariable String vehiclePlate) {
        if (this.maintenanceRepository.findByVehiclePlate(vehiclePlate).isEmpty()) {
            throw new MaintenanceNotFoundException("Nenhuma manutenção encontrada com a placa: " + vehiclePlate);
        }
        return this.maintenanceRepository.findByVehiclePlate(vehiclePlate);
    }

    @Transactional
    public Maintenance update(@PathVariable UUID id, MaintenanceUpdateDTO dto) {

        Maintenance maintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new MaintenanceNotFoundException("Manutenção não encontrada"));

        if (dto.getScheduledDate() != null) {
            maintenance.setScheduledDate(dto.getScheduledDate());
        }

        if (dto.getCompletedDate() != null) {
            maintenance.setCompletedDate(dto.getCompletedDate());
        }

        if (dto.getCost() != null) {
            maintenance.setCost(dto.getCost());
        }

        if (dto.getStatus() != null) {
            maintenance.setStatus(dto.getStatus());
        }

        return maintenanceRepository.save(maintenance);
    }

    @Transactional
    public void updateStatus(@PathVariable UUID id, MaintenanceStatusUpdateDTO dto) {

        Maintenance maintenance = maintenanceRepository.findById(id)
                .orElseThrow(() -> new MaintenanceNotFoundException("Manutenção não encontrada"));

        maintenance.setStatus(dto.getStatus());
    }

    public void deleteMaintenance(@PathVariable UUID id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new MaintenanceNotFoundException("Manutenção não encontrada");
        }
        maintenanceRepository.deleteById(id);
    }
}
