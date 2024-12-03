package com.hasan.departmentservice.service;

import com.hasan.departmentservice.dto.DepartmentDto;
import com.hasan.departmentservice.entity.Department;
import com.hasan.departmentservice.mapper.DepartmentMapper;
import com.hasan.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {

        Department department = departmentMapper.toEntity(departmentDto);
        departmentRepository.save(department);

        return departmentMapper.toDto(department);
    }

    @Override
    public DepartmentDto findByDepartmentCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        return departmentMapper.toDto(department);
    }

    @Override
    public List<DepartmentDto> findAll() {
        List<Department> departments = departmentRepository.findAll();


        return departments.stream()
                .map(department -> departmentMapper.toDto(department))
                .toList();
    }
}
