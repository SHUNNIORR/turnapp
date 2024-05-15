package com.shunnior.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Set;
@Entity
public class Employee extends ApplicationUser {

    @OneToMany()
    private List<EmployeeType> type;
    @OneToMany()
    private List<EmployeeService> employeeService;
    private boolean available;

    public Employee() {
        super();
    }
    public Employee(Integer userId, String username, String name, String lastName, String email, String password, Set<Role> authorities, List<EmployeeType> type, List<EmployeeService> employeeService, boolean available) {
        super(userId, username, name, lastName, email, password, authorities);
        this.type = type;
        this.employeeService = employeeService;
        this.available = available;
    }
}