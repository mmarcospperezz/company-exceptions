package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.exceptions.DepartmentNotFound;
import org.example.exceptions.EmployeeNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Company {
    private String name;
    private String cif;
    private Map<String, Department> departmentByName;

    public List<Employee> getEmployeesByDepartment(String departmentName) throws DepartmentNotFound {
        Department department = departmentByName.get(departmentName);
        if (department == null) {
            throw new DepartmentNotFound(departmentName);
        }
        return department.getEmployees();
    }

    public Department getDepartmentByName(String departmentName) throws DepartmentNotFound{
        Department department = departmentByName.get(departmentName);
        if (department == null) {
            throw new DepartmentNotFound(departmentName);
        }
        return department;
    }

    public Employee getEmployeeByNif(String nif) throws EmployeeNotFound {
        for (Department department : departmentByName.values()) {
            for (Employee employee : department.getEmployees()) {
                if (employee.getNif().equals(nif)) {
                    return employee;
                }
            }
        }
        throw new EmployeeNotFound(nif);
    }

    public List<Department> showDepartments(){
        List<Department> departments = new ArrayList<>();
        for (Department department : departmentByName.values()) {
            departments.add(department);
        }
        return departments;

    }
}
