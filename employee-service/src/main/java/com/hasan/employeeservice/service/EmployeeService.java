package com.hasan.employeeservice.service;

import com.hasan.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);
    EmployeeDto findById(Long id);
}
