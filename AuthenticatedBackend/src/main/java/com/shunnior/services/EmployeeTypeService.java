package com.shunnior.services;

import com.shunnior.models.ApiResponse;
import com.shunnior.models.EmployeeService;
import com.shunnior.models.EmployeeType;
import com.shunnior.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTypeService {
    @Autowired
    EmployeeTypeRepository employeeTypeRepository;

    public ApiResponse<EmployeeType> saveEmployeeType(EmployeeType employeeType){
        EmployeeType newEmployeeType = employeeTypeRepository.save(employeeType);
        ApiResponse<EmployeeType> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage("Creado con exito");
        response.setData(newEmployeeType);
        return response;
    }
}
