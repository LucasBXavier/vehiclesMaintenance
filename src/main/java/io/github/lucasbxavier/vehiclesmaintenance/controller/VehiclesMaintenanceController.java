package io.github.lucasbxavier.vehiclesmaintenance.controller;


import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.service.MaintenanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vehicles-maintenance")
@AllArgsConstructor
public class VehiclesMaintenanceController {

    private MaintenanceService service;

    @PostMapping
    public ResponseEntity createMaintenance(@RequestBody MaintenanceRequestDTO dto) {
        service.createMaintenance(dto);
        return ResponseEntity.ok().body("manutenção criada");
    }

    @GetMapping
    public ResponseEntity<?> getVehiclesMaintenance() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMaintenanceById(@PathVariable UUID id) {
       return ResponseEntity.ok().body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMaintenance(@PathVariable UUID id) {
        service.deleteMaintenance(id);
        return ResponseEntity.ok().body("manutenção deletada");
    }
}
