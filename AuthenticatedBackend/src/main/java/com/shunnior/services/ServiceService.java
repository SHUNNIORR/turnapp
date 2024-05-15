package com.shunnior.services;

import com.shunnior.models.ApiResponse;
import com.shunnior.models.EmployeeService;
import com.shunnior.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    public ApiResponse<EmployeeService> saveService(EmployeeService employeeService){
        EmployeeService newEmployeeService = serviceRepository.save(employeeService);
        ApiResponse<EmployeeService> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Creado con exito");
        response.setData(newEmployeeService);
        return response;
    }

}