package org.example.components;

import org.example.model.Department;
import org.example.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DepartmentReader implements Reader<Department> {
    private Scanner scanner;
    private EmployeeReader employeeReader;

    public DepartmentReader(Scanner scanner, EmployeeReader employeeReader) {
        this.scanner = scanner;
        this.employeeReader = employeeReader;
    }

    public Department read() {
        System.out.println("Introduce el nombre del departamento:");
        String name = scanner.nextLine();

        System.out.println("Introduce el número de empleados:");
        int numEmployees =scanner.nextInt();
        scanner.nextLine();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Employee " + (i + 1) + ":");
            Employee employee = employeeReader.read();
            employees.add(employee);
        }

        return new Department(
                name,
                employees
        );
    }
}
