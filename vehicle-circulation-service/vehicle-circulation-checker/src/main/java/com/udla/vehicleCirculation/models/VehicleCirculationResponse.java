package com.udla.vehicleCirculation.models;

/**
 * Representa la respuesta que se devuelve al cliente después de
 * consultar si un vehículo puede circular.
 */
public class VehicleCirculationResponse {

    private String licensePlate;
    private String message;
    private boolean isAllowedToCirculate;

    public VehicleCirculationResponse() {
    }

    public VehicleCirculationResponse(String licensePlate, String message, boolean isAllowedToCirculate) {
        this.licensePlate = licensePlate;
        this.message = message;
        this.isAllowedToCirculate = isAllowedToCirculate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAllowedToCirculate() {
        return isAllowedToCirculate;
    }

    public void setAllowedToCirculate(boolean allowedToCirculate) {
        isAllowedToCirculate = allowedToCirculate;
    }
}
