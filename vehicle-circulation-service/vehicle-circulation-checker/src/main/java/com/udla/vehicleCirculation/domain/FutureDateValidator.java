package com.udla.vehicleCirculation.domain;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Valida que una fecha y hora no esté en el pasado.
 */
@Component
public class FutureDateValidator {

    /**
     * Valida que la fecha y hora proporcionadas no sean anteriores a la actual.
     *
     * @param dateTime la fecha y hora a validar
     * @throws IllegalArgumentException si la fecha/hora está en el pasado
     */
    public void validateNotInPast(LocalDateTime dateTime) {
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La fecha y hora no pueden estar en el pasado.");
        }
    }
}
