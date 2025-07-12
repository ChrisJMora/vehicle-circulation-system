package com.udla.vehicleCirculation.controllers;

import com.udla.vehicleCirculation.models.VehicleCheckInput;
import com.udla.vehicleCirculation.models.VehicleCheckResult;
import com.udla.vehicleCirculation.models.VehicleCirculationRequest;
import com.udla.vehicleCirculation.models.VehicleCirculationResponse;
import com.udla.vehicleCirculation.services.VehicleCirculationMapper;
import com.udla.vehicleCirculation.services.VehicleCirculationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST que permite consultar si un vehículo
 * puede circular en una fecha y hora determinada.
 */
@RestController
@RequestMapping("/api/circulation")
public class VehicleCirculationController {

    private final VehicleCirculationService service;
    private final VehicleCirculationMapper mapper;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param service servicio principal que aplica la lógica de circulación
     * @param mapper objeto de mapeo entre DTOs y modelos internos
     */
    public VehicleCirculationController(VehicleCirculationService service, VehicleCirculationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Endpoint para verificar si un vehículo puede circular.
     *
     * @param request DTO con placa, fecha y hora
     * @return respuesta con el resultado de la evaluación
     */
    @PostMapping("/check")
    public ResponseEntity<VehicleCirculationResponse> checkVehicleCirculationStatus(
            @Valid @RequestBody VehicleCirculationRequest request) {

        VehicleCheckInput input = mapper.toDomainModel(request);
        VehicleCheckResult result = service.checkRestriction(input);
        VehicleCirculationResponse response = mapper.toDto(result);

        return ResponseEntity.ok(response);
    }
}

