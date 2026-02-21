package io.github.lucasbxavier.vehiclesmaintenance.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceNotFoundExceptionTest {

    @Test
    void shouldCreateExceptionWithMessage() {
        String message = "Manutenção não encontrada";

        MaintenanceNotFoundException exception = new MaintenanceNotFoundException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    void shouldBeInstanceOfRuntimeException() {
        MaintenanceNotFoundException exception = new MaintenanceNotFoundException("erro");

        assertTrue(exception instanceof RuntimeException);
    }

}