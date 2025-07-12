package com.udla.vehicleCirculation.services;

import com.udla.vehicleCirculation.models.VehicleCirculationRequest;
import com.udla.vehicleCirculation.models.VehicleCirculationResponse;
import com.udla.vehicleCirculation.models.VehicleCheckInput;
import com.udla.vehicleCirculation.models.VehicleCheckResult;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Mapper encargado de convertir entre los DTOs y los modelos internos del sistema.
 */
@Service
public class VehicleCirculationMapper {

    /**
     * Convierte un DTO de request a un modelo interno de entrada.
     *
     * @param request el DTO recibido del cliente
     * @return el modelo interno listo para usar en el servicio
     */
    public VehicleCheckInput toDomainModel(VehicleCirculationRequest request) {
        LocalDateTime dateTime = LocalDateTime.of(request.getDate(), request.getTime());
        return new VehicleCheckInput(request.getLicensePlate(), dateTime);
    }

    /**
     * Convierte el resultado del servicio en una respuesta para el cliente.
     *
     * @param result el modelo interno con el resultado
     * @return un DTO que será enviado como respuesta
     */
    public VehicleCirculationResponse toDto(VehicleCheckResult result) {
        return new VehicleCirculationResponse(
                result.getLicensePlate(),
                result.getMessage(),
                result.isAllowed()
        );
    }
}
