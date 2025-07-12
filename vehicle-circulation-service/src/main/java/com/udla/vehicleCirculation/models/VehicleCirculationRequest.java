package com.udla.vehicleCirculation.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Representa la solicitud enviada por el cliente para verificar
 * si un vehículo puede circular en una fecha y hora determinadas.
 */
public class VehicleCirculationRequest {

    @NotBlank(message = "La placa no puede estar vacía.")
    private String licensePlate;

    @NotNull(message = "La fecha es obligatoria.")
    private LocalDate date;

    @NotNull(message = "La hora es obligatoria.")
    private LocalTime time;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
