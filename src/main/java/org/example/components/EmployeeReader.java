package org.example.components;

import org.example.model.Employee;

import java.util.Scanner;

public class EmployeeReader implements Reader<Employee> {
    private final Scanner scanner;

    public EmployeeReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Employee read() {
        System.out.println("Introduce el nif del empleado:");
        String nif = scanner.nextLine();
        System.out.println("Introduce el nombre del empleado:");
        String name = scanner.nextLine();
        System.out.println("Introduce el apellido del empleado:");
        String surname = scanner.nextLine();
        System.out.println("Introduce el rol del empleado:");
        String role = scanner.nextLine();

        return new Employee(
                nif,
                name,
                surname,
                role
        );
    }
}
