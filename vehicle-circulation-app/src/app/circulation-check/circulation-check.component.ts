import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CirculationService, VehicleCirculationRequest, VehicleCirculationResponse } from '../services/circulation.service';

@Component({
  selector: 'app-circulation-check',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './circulation-check.component.html',
})
export class CirculationCheckComponent {
  request: VehicleCirculationRequest = {
    licensePlate: '',
    date: '',
    time: ''
  };

  response?: VehicleCirculationResponse;
  error?: string;

  constructor(private circulationService: CirculationService) {}

  onSubmit() {
    this.circulationService.checkCirculation(this.request).subscribe({
      next: (res) => {
        this.response = res;
        this.error = undefined;
      },
      error: () => {
        this.error = 'Error al consultar el backend.';
        this.response = undefined;
      }
    });
  }
}
