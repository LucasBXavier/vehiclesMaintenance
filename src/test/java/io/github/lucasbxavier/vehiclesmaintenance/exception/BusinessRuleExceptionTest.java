package io.github.lucasbxavier.vehiclesmaintenance.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusinessRuleExceptionTest {
    @Test
    void shouldCreateExceptionWithMessage() {
        String message = "Regra de negócio violada";

        BusinessRuleException exception = new BusinessRuleException(message);

        assertEquals(message, exception.getMessage());
    }

    @Test
    void shouldBeInstanceOfRuntimeException() {
        BusinessRuleException exception = new BusinessRuleException("erro");

        assertTrue(exception instanceof RuntimeException);
    }
}