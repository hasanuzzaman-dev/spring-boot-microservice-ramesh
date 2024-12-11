package com.hasan.employeeservice.service;

import com.hasan.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
public interface APIClient {

    @GetMapping("/api/departments/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String code);
}
