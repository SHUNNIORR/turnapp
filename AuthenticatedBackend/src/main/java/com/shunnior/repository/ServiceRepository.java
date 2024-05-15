package com.shunnior.repository;

import com.shunnior.models.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<EmployeeService, Long> {
}
