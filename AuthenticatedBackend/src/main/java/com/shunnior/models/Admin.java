package com.shunnior.models;

import java.util.Set;

public class Admin extends ApplicationUser{

    public Admin(Integer userId, String username, String name, String lastName, String email, String password, Set<Role> authorities) {
        super(userId, username,name,lastName,email, password, authorities);
    }

    @Override
    public void generateAppointment() {
        super.generateAppointment();
        // Lógica específica para generar una cita como administrador
    }
}
