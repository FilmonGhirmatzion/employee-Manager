import { Component, OnInit } from '@angular/core';
import { Employee } from './employee';
import { EmployeeService } from './employee.service'; // Import the EmployeeService class
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [EmployeeService] // Add the EmployeeService as a provider
})
export class AppComponent implements OnInit {
  // title = 'employeemanagerapp';
  public employees: Employee[] = [];
  public editEmployee: Employee | undefined;
  public deleteEmployee: Employee | undefined;

  constructor(private employeeService: EmployeeService) {}

  ngOnInit() {
    this.getEmployees();
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) =>
        alert(error.message)
    );
  }

  public onAddEmployee(addForm: NgForm): void {
    document.getElementById('add-employee-form')?.click();
    this.employeeService.addEmployee(addForm.value).subscribe(
      (response: Employee []) => {
        console.log(response);
        this.getEmployees();
        // addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
        // addForm.reset();
    }
    );
  }

  public onupdateEmployee(employee: Employee): void {
     this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
        // addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
        // addForm.reset();
    }
    );
  }
  public onDeleteEmployee(employeeId: number): void {
    this.employeeService.deleteEmployee(employeeId).subscribe(
     (response: void) => {
       console.log(response);
       this.getEmployees();

     },
     (error: HttpErrorResponse) => {
       alert(error.message)

   }
   );
  }

  public onOpenModal(employee: Employee, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal')
    if (mode == 'add'){
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (mode == 'update'){
      this.editEmployee = employee
      button.setAttribute('data-target', '#editEmployeeModal');
    }
    if (mode == 'delete'){
      this.deleteEmployee = employee
      button.setAttribute('data-target', '#deleteEmployeeModal');
    }
    container?.appendChild(button);
    button.click();

  }


}
