import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface VehicleCirculationRequest {
  licensePlate: string;
  date: string; // 'yyyy-MM-dd'
  time: string; // 'HH:mm:ss'
}

export interface VehicleCirculationResponse {
  licensePlate: string;
  message: string;
  allowedToCirculate: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class CirculationService {
  private readonly apiUrl = 'http://localhost:8080/api/circulation/check';

  constructor(private http: HttpClient) {}

  checkCirculation(request: VehicleCirculationRequest): Observable<VehicleCirculationResponse> {
    return this.http.post<VehicleCirculationResponse>(this.apiUrl, request);
  }
}
