package com.udla.vehicleCirculation.models;

/**
 * Representa el resultado interno de la evaluación de circulación.
 * Contiene la placa del vehículo, si está o no permitido circular,
 * y un mensaje explicativo.
 */
public class VehicleCheckResult {

    private final String licensePlate;
    private final boolean allowed;
    private final String message;

    /**
     * Constructor principal.
     *
     * @param licensePlate placa del vehículo
     * @param allowed true si el vehículo puede circular
     * @param message mensaje explicativo
     */
    public VehicleCheckResult(String licensePlate, boolean allowed, String message) {
        this.licensePlate = licensePlate;
        this.allowed = allowed;
        this.message = message;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public String getMessage() {
        return message;
    }
}
