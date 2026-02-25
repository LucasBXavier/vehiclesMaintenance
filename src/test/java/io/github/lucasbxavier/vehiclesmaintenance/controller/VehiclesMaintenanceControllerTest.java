package io.github.lucasbxavier.vehiclesmaintenance.controller;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceRequestDTO;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceUpdateDTO;
import io.github.lucasbxavier.vehiclesmaintenance.service.MaintenanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VehiclesMaintenanceControllerTest {
    @Mock
    private MaintenanceService service;

    @InjectMocks
    private VehiclesMaintenanceController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateMaintenance() {
        MaintenanceRequestDTO dto = new MaintenanceRequestDTO();

        ResponseEntity<String> response = controller.createMaintenance(dto);

        verify(service).createMaintenance(dto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("manutenção criada", response.getBody());
    }

    @Test
    void shouldReturnAllMaintenances() {
        List<Maintenance> result = List.of();
        when(service.findAll()).thenReturn(result);

        ResponseEntity<List<?>> response = controller.getVehiclesMaintenance();

        verify(service).findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(result, response.getBody());
    }

    @Test
    void shouldReturnMaintenanceById() {
        UUID id = UUID.randomUUID();
        Maintenance maintenance = new Maintenance();
        when(service.findById(id)).thenReturn(Optional.of(maintenance));

        ResponseEntity<?> response = controller.getMaintenanceById(id);

        verify(service).findById(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(maintenance, response.getBody());
    }

    @Test
    void shouldReturnMaintenancesByStatus() {
        List<Maintenance> result = List.of();
        when(service.findByStatus("COMPLETED")).thenReturn(result);

        ResponseEntity<?> response = controller.getMaintenanceByStatus("COMPLETED");

        verify(service).findByStatus("COMPLETED");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(result, response.getBody());
    }

    @Test
    void shouldUpdateMaintenance() {
        UUID id = UUID.randomUUID();
        MaintenanceUpdateDTO dto = new MaintenanceUpdateDTO();

        ResponseEntity<String> response = controller.updateMaintenance(id, dto);

        verify(service).update(id, dto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("manutenção atualizada", response.getBody());
    }

    @Test
    void shouldDeleteMaintenance() {
        UUID id = UUID.randomUUID();

        ResponseEntity<String> response = controller.deleteMaintenance(id);

        verify(service).deleteMaintenance(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("manutenção deletada", response.getBody());
    }

}