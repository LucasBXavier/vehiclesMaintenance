package io.github.lucasbxavier.vehiclesmaintenance.service;

import io.github.lucasbxavier.vehiclesmaintenance.domain.entities.Maintenance;
import io.github.lucasbxavier.vehiclesmaintenance.domain.enums.MaintenanceStatus;
import io.github.lucasbxavier.vehiclesmaintenance.dto.MaintenanceUpdateDTO;
import io.github.lucasbxavier.vehiclesmaintenance.exception.MaintenanceNotFoundException;
import io.github.lucasbxavier.vehiclesmaintenance.mapper.MaintenanceMapper;
import io.github.lucasbxavier.vehiclesmaintenance.repository.MaintenanceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MaintenanceServiceTest {

    @Mock
    private MaintenanceRepository repository;

    @Mock
    private MaintenanceMapper mapper;

    @InjectMocks
    private MaintenanceService service;

    @Test
    void shouldReturnAllMaintenances() {
        Maintenance m = new Maintenance();
        when(repository.findAll()).thenReturn(List.of(m));

        List<Maintenance> result = service.findAll();

        assertEquals(1, result.size());
    }

    @Test
    void shouldThrowWhenNoMaintenancesFound() {
        when(repository.findAll()).thenReturn(List.of());

        assertThrows(MaintenanceNotFoundException.class,
                () -> service.findAll());
    }

    @Test
    void shouldReturnMaintenanceById() {
        UUID id = UUID.randomUUID();
        when(repository.existsById(id)).thenReturn(true);
        when(repository.findById(id)).thenReturn(Optional.of(new Maintenance()));

        Object result = service.findById(id);

        assertTrue(result instanceof Optional);
    }

    @Test
    void shouldThrowWhenMaintenanceNotFoundById() {
        UUID id = UUID.randomUUID();
        when(repository.existsById(id)).thenReturn(false);

        assertThrows(MaintenanceNotFoundException.class,
                () -> service.findById(id));
    }

    @Test
    void shouldFindByStatus() {
        when(repository.findByStatus(MaintenanceStatus.COMPLETO))
                .thenReturn(List.of(new Maintenance()));

        List<Maintenance> result = service.findByStatus("COMPLETO");

        assertEquals(1, result.size());
    }

    @Test
    void shouldThrowWhenStatusNotFound() {
        when(repository.findByStatus(MaintenanceStatus.CANCELADO))
                .thenReturn(List.of());

        assertThrows(MaintenanceNotFoundException.class,
                () -> service.findByStatus("CANCELADO"));
    }

    @Test
    void shouldUpdateMaintenance() {
        UUID id = UUID.randomUUID();
        Maintenance entity = new Maintenance();
        MaintenanceUpdateDTO dto = new MaintenanceUpdateDTO();
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        service.update(id, dto);

        verify(repository).save(entity);
    }

    @Test
    void shouldDeleteMaintenance() {
        UUID id = UUID.randomUUID();
        when(repository.existsById(id)).thenReturn(true);

        service.deleteMaintenance(id);

        verify(repository).deleteById(id);
    }

}