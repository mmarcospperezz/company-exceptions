package org.example.components;

import org.example.model.Company;
import org.example.model.Department;

import java.util.Scanner;

public class CompanyApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeReader employeeReader = new EmployeeReader(scanner);
        DepartmentReader departmentReader = new DepartmentReader(scanner, employeeReader);
        CompanyReader companyReader = new CompanyReader(scanner, departmentReader);

        Company company = companyReader.read();

        int option;
        do {
            System.out.println("--- Menu ---");
            System.out.println("1. Mostrar departamentos");
            System.out.println("2. Ver empleados del departamento");
            System.out.println("3. Ver departamento");
            System.out.println("4. Ver empleado");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    company.showDepartments();
                    break;
                case 2:
                    String departmentName = scanner.nextLine();
                    company.getEmployeesByDepartment();
                    break;
                case 3:
                    company.getDepartmentByName();
                    break;
                case 4:
                    String nif = scanner.nextLine();
                    company.getEmployeeByNif();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 5);
    }


}
