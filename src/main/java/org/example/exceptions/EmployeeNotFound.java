package org.example.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Getter
public class EmployeeNotFound extends Exception {
    private final String nif;

    public EmployeeNotFound(String nif) {
        super("Employee" + nif + "not found");
        this.nif = nif;
    }
}
