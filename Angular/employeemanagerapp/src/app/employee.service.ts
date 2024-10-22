import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Employee } from "./employee";
import { HttpClient } from "@angular/common/http";
import { environment } from "../environment/environment";

@Injectable({
  providedIn: "root"
})
export class EmployeeService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.apiServerUrl}/employee/list`);
  }

  public addEmployees(employee: Employee): Observable<Employee[]> {
    return this.http.post<Employee[]>(`${this.apiServerUrl}/employee/add`, employee);
  }
  public deleteEmployee(employeeId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/employee/delete/${employeeId}`);
  }
  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<Employee>(`${this.apiServerUrl}/employee/update`, employee);
  }
}
