package com.udla.vehicleCirculation.models;

import java.time.LocalDateTime;

/**
 * Representa la entrada interna del servicio para validar circulación vehicular.
 * Se construye a partir del DTO externo (Request) y contiene la placa del vehículo
 * y la fecha/hora combinadas.
 */
public class VehicleCheckInput {

    private final String licensePlate;
    private final LocalDateTime dateTime;

    /**
     * Constructor principal.
     *
     * @param licensePlate placa del vehículo
     * @param dateTime fecha y hora de la consulta
     */
    public VehicleCheckInput(String licensePlate, LocalDateTime dateTime) {
        this.licensePlate = licensePlate;
        this.dateTime = dateTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
