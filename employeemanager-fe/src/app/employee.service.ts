import { Observable } from 'rxjs';
import { Employee } from './employee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environments';

/*Injectable tells Angular:
“Create this service and make it available globally in the entire application.”
Simple explanation
@Injectable → marks the class as a service that can be injected
providedIn: 'root' → Angular creates one single instance (singleton) and shares it everywhere
*/
@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/all`);
  }

  public addEmployees(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(
      `${this.apiServerUrl}/employee/add`,
      employee,
    );
  }

  public updateEmployees(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(
      `${this.apiServerUrl}/employee/update`,
      employee,
    );
  }

  public deleteEmployees(employeeId: number): Observable<void> {
    return this.http.delete<void>(
      `${this.apiServerUrl}/employee/delete/${employeeId}`,
    );
  }
}
