package com.udla.vehicleCirculation.domain;

import java.time.LocalDateTime;

/**
 * Contiene la lógica de negocio para determinar si un vehículo
 * tiene restricción de circulación en una fecha y hora determinadas.
 */
public class CirculationRestrictionRule {

    /**
     * Verifica si el vehículo está restringido para circular.
     *
     * @param licensePlate placa del vehículo
     * @param dateTime fecha y hora a verificar
     * @return true si el vehículo NO puede circular
     */
    public boolean isRestricted(String licensePlate, LocalDateTime dateTime) {
        RestrictedDay day = RestrictedDay.from(dateTime.toLocalDate());
        if (day == null) {
            return false; // En el caso de que sea fin de semana
        }

        Integer lastDigit = getLastDigit(licensePlate);

        boolean digitRestricted = day.isDigitRestricted(lastDigit);
        boolean hourRestricted = day.getRestrictedHours().contains(dateTime.getHour());

        return digitRestricted && hourRestricted;
    }

    /**
     * Extrae el último dígito numérico de la placa.
     *
     * @param plate la placa del vehículo
     * @return el último dígito numérico o null si no existe
     */
    private Integer getLastDigit(String plate) {
        char lastChar = plate.charAt(plate.length() - 1);
        if (Character.isDigit(lastChar)) {
            return Character.getNumericValue(lastChar);
        }
        throw new IllegalArgumentException("La placa no termina en un dígito numérico.");
    }
}
