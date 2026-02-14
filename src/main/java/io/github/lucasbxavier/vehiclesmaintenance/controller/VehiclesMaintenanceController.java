package io.github.lucasbxavier.vehiclesmaintenance.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vehicles-maintenance")
public class VehiclesMaintenanceController {

    @GetMapping
    public ResponseEntity<?> getVehiclesMaintenance() {
        return ResponseEntity.ok("Hello World");
    }
}
