package io.github.lucasbxavier.vehiclesmaintenance.service;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.exception.BusinessRuleException;
import io.github.lucasbxavier.vehiclesmaintenance.exception.MaintenanceNotFoundException;
import io.github.lucasbxavier.vehiclesmaintenance.mapper.MaintenanceMapper;
import io.github.lucasbxavier.vehiclesmaintenance.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    private MaintenanceMapper mapper;


    public void createMaintenance(@RequestBody MaintenanceRequestDTO dto) {
        var manutencao = mapper.toEntity(dto);
        if(manutencao.getScheduledDate().isBefore(manutencao.getCompletedDate())) {
            throw new BusinessRuleException("A data de conclusão não pode ser anterior à data agendada.");
        }
        if(manutencao.getScheduledDate().isAfter(manutencao.getCompletedDate())) {
            throw new BusinessRuleException("A data agendada não pode ser posterior à data de conclusão.");
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

    public Object findById(@PathVariable UUID id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new MaintenanceNotFoundException("Manutenção não encontrada");
        }
        return this.maintenanceRepository.findById(id);
    }

    public List<Maintenance> findByStatus(String status) {
        if (this.maintenanceRepository.findByStatus(MaintenanceStatus.valueOf(status)).isEmpty()) {
            throw new MaintenanceNotFoundException("Nenhuma manutenção encontrada com o status: " + status);
        }
        return this.maintenanceRepository.findByStatus(MaintenanceStatus.valueOf(status));
    }

    public void update(UUID id, @RequestBody MaintenanceRequestDTO dto) {
        var manutencao = maintenanceRepository.findById(id);
        if (manutencao.isEmpty()) {
            throw new MaintenanceNotFoundException("Manutenção não encontrada");
        }
        mapper.updateEntity(manutencao.get(), dto);
        maintenanceRepository.save(manutencao.get());
    }

    public void deleteMaintenance(UUID id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new MaintenanceNotFoundException("Manutenção não encontrada");
        }
        maintenanceRepository.deleteById(id);
    }
}
