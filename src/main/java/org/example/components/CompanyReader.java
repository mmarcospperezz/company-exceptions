package org.example.components;

import org.example.model.Company;
import org.example.model.Department;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompanyReader implements Reader<Company>{
    private Scanner scanner;
    private DepartmentReader departmentReader;

    public CompanyReader(Scanner scanner, DepartmentReader departmentReader) {
        this.scanner = scanner;
        this.departmentReader = departmentReader;
    }

    @Override
    public Company read() {
        System.out.println("Introduce el nombre de la empresa:");
        String name = scanner.nextLine();
        System.out.println("Introduce el cif de la empresa:");
        String cif = scanner.nextLine();

        System.out.println("Introduce el número de departamentos:");
        int numDepartments = scanner.nextInt();
        scanner.nextLine();
        Map<String, Department> departmentByName = new HashMap<>();
        for (int i = 0; i < numDepartments; i++) {
            System.out.println("Department " + (i + 1) + ":");
            Department department = departmentReader.read();
            departmentByName.put(department.getName(), department);
        }

        return new Company(
                name,
                cif,
                departmentByName
        );
    }
}
