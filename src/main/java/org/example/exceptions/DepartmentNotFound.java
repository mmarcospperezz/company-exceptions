package org.example.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class DepartmentNotFound extends Exception{
    private final String name;

    public DepartmentNotFound(String name) {
        super("Department "+ name + "not found");
        this.name = name;
    }
}
