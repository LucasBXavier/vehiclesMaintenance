package io.github.lucasbxavier.vehiclesmaintenance.controller;


import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceStatusUpdateDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceUpdateDTO;
import io.github.lucasbxavier.vehiclesmaintenance.service.MaintenanceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vehicles-maintenance")
@AllArgsConstructor
public class VehiclesMaintenanceController {

    private MaintenanceService service;

    @Operation(
            summary = "Criar manutenção",
            description = "Cria um novo registro de manutenção para um veículo."
    )
    @PostMapping
    public ResponseEntity<String> createMaintenance(@RequestBody MaintenanceRequestDTO dto) {
        service.createMaintenance(dto);
        return ResponseEntity.ok().body("manutenção criada");
    }

    @Operation(
            summary = "Listar manutenções",
            description = "Retorna uma lista de todas as manutenções de veículos registradas."
    )
    @GetMapping
    public ResponseEntity<List<?>> getVehiclesMaintenance() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Operation(
            summary = "Buscar manutenção por ID",
            description = "Busca uma manutenção específica de um veículo através do ID."
    )
    @GetMapping("/{id}")
    public ResponseEntity<?> getMaintenanceById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(
            summary = "Buscar manutenção por status",
            description = "Busca manutenções de veículos com base no status fornecido."
    )
    @GetMapping("/status/{status}")
    public ResponseEntity<?> getMaintenanceByStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.findByStatus(status));
    }

    @Operation(
            summary = "Buscar manutenção por placa do veículo",
            description = "Busca manutenções de veículos com base na placa fornecida."
    )
    @GetMapping("/placaVeiculo/{vehiclePlate}")
    public ResponseEntity<?> getMaintenanceByPlate(@PathVariable String vehiclePlate) {
        return ResponseEntity.ok(service.findByPlate(vehiclePlate));
    }

    @Operation(
            summary = "Atualiza a manutenção",
            description = "Atualiza uma manutenção existente com base no ID necessitando do corpo do MaintenanceRequestDTO."
    )
    @PatchMapping("/{id}")
    public ResponseEntity<String> updateMaintenance(@PathVariable UUID id, @RequestBody MaintenanceUpdateDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().body("manutenção atualizada");
    }

    @Operation(
            summary = "Atualiza o status da manutenção",
            description = "Atualiza o status de uma manutenção existente com base no ID necessitando do corpo do MaintenanceStatusUpdateDTO."
    )
    @PatchMapping("/{id}/status")
    public ResponseEntity<String> updateMaintenanceStatus(@PathVariable UUID id, @RequestBody MaintenanceStatusUpdateDTO dto) {
        service.updateStatus(id, dto);
        return ResponseEntity.ok().body("status da manutenção atualizado");
    }

    @Operation(
            summary = "Excluir manutenção",
            description = "Remove uma manutenção existente com base no ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaintenance(@PathVariable UUID id) {
        service.deleteMaintenance(id);
        return ResponseEntity.ok().body("manutenção deletada");
    }
}
