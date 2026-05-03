package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyDto {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public CompanyDto(List<Employee> employees, String name, int id) {
        this.employees = employees;
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
