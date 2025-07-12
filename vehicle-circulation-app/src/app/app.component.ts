import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CirculationCheckComponent } from './circulation-check/circulation-check.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    HttpClientModule,
    CirculationCheckComponent
  ],
  template: `<app-circulation-check></app-circulation-check>`,
})
export class AppComponent {}
