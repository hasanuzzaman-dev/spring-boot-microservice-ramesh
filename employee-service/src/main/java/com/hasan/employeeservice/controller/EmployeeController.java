package com.hasan.employeeservice.controller;

import com.hasan.employeeservice.dto.EmployeeDto;
import com.hasan.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.save(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long id) {
        EmployeeDto employeeDto = employeeService.findById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
