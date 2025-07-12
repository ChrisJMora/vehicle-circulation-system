package com.udla.vehicleCirculation.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 * Enum que representa los días de la semana que tienen restricción
 * de circulación vehicular según el último dígito de la placa y horarios específicos.
 */
public enum RestrictedDay {
    MONDAY(List.of(1, 2)),
    TUESDAY(List.of(3, 4)),
    WEDNESDAY(List.of(5, 6)),
    THURSDAY(List.of(7, 8)),
    FRIDAY(List.of(9, 0));

    private final List<Integer> restrictedDigits;

    RestrictedDay(List<Integer> restrictedDigits) {
        this.restrictedDigits = restrictedDigits;
    }

    /**
     * Verifica si un dígito está restringido en este día.
     *
     * @param digit último dígito de la placa
     * @return true si el dígito está restringido en este día
     */
    public boolean isDigitRestricted(int digit) {
        return restrictedDigits.contains(digit);
    }

    /**
     * Retorna el día restringido correspondiente a una fecha.
     *
     * @param date la fecha a evaluar
     * @return el día restringido, o null si es fin de semana
     */
    public static RestrictedDay from(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return switch (dayOfWeek) {
            case MONDAY -> MONDAY;
            case TUESDAY -> TUESDAY;
            case WEDNESDAY -> WEDNESDAY;
            case THURSDAY -> THURSDAY;
            case FRIDAY -> FRIDAY;
            default -> null;
        };
    }

    /**
     * Devuelve las horas restringidas por defecto.
     * Las restricciones se aplican en las mañanas y tardes.
     *
     * @return lista de horas restringidas
     */
    public List<Integer> getRestrictedHours() {
        return List.of(7, 8, 16, 17);
    }
}
