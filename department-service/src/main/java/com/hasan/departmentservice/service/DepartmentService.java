package com.hasan.departmentservice.service;

import com.hasan.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto save(DepartmentDto departmentDto);
    DepartmentDto findByDepartmentCode(String  code);
    List<DepartmentDto> findAll();
}
