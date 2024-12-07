package com.hasan.employeeservice.service;

import com.hasan.employeeservice.dto.DepartmentDto;
import com.hasan.employeeservice.dto.EmployeeDto;
import com.hasan.employeeservice.entity.Employee;
import com.hasan.employeeservice.mapper.EmployeeMapper;
import com.hasan.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final RestTemplate restTemplate;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {

        Employee employee = employeeMapper.toEntity(employeeDto);
        employeeRepository.save(employee);

        return employeeMapper.toDto(employee);
    }

    @Override
    public EmployeeDto findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        EmployeeDto employeeDto = employeeMapper.toDto(employee);

        if (employee != null && employee.getDepartmentCode() != null) {
            ResponseEntity<DepartmentDto> responseEntity =   restTemplate.getForEntity(
                    "http://localhost:8080/api/departments/"+employee.getDepartmentCode(),
                    DepartmentDto.class
            );

            DepartmentDto departmentDto = responseEntity.getBody();
            employeeDto.setDepartment(departmentDto);
        }

        return employeeDto;
    }
}