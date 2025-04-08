package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Department {
    private String name;
    private List<Employee> employees;
}
