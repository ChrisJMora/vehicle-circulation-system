package com.udla.vehicleCirculation.services;


import com.udla.vehicleCirculation.domain.CirculationRestrictionRule;
import com.udla.vehicleCirculation.domain.FutureDateValidator;
import com.udla.vehicleCirculation.models.VehicleCheckInput;
import com.udla.vehicleCirculation.models.VehicleCheckResult;
import org.springframework.stereotype.Service;

/**
 * Servicio que contiene la lógica de aplicación para verificar
 * si un vehículo puede circular en una fecha y hora determinadas.
 */
@Service
public class VehicleCirculationService {

    private final CirculationRestrictionRule restrictionRule;
    private final FutureDateValidator dateValidator;

    /**
     * Constructor del servicio.
     *
     * @param restrictionRule regla que define las restricciones
     * @param dateValidator validador de fechas
     */
    public VehicleCirculationService(CirculationRestrictionRule restrictionRule,
                                     FutureDateValidator dateValidator) {
        this.restrictionRule = restrictionRule;
        this.dateValidator = dateValidator;
    }

    /**
     * Verifica si el vehículo con los datos dados puede circular.
     *
     * @param input modelo interno con placa y fecha/hora
     * @return resultado del chequeo
     */
    public VehicleCheckResult checkRestriction(VehicleCheckInput input) {
        dateValidator.validateNotInPast(input.getDateTime());

        boolean restricted = restrictionRule.isRestricted(input.getLicensePlate(), input.getDateTime());

        String message = restricted
                ? "El vehículo NO puede circular en la fecha y hora ingresadas."
                : "El vehículo PUEDE circular en la fecha y hora ingresadas.";

        return new VehicleCheckResult(
                input.getLicensePlate(),
                !restricted,
                message
        );
    }
}
