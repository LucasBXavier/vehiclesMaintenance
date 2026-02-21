package io.github.lucasbxavier.vehiclesmaintenance.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ErrorResponseDTO {

    private final String message;
    private final int status;
    private final LocalDateTime timestamp;
}
