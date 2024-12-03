package com.hasan.departmentservice.mapper;

import com.hasan.departmentservice.dto.DepartmentDto;
import com.hasan.departmentservice.entity.Department;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentDto toDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        try {
            BeanUtils.copyProperties(department, departmentDto);
        }catch (Exception e){
            e.printStackTrace();
        }

        return departmentDto;
    }

    public Department toEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        try {
            BeanUtils.copyProperties(departmentDto, department);
        }catch (Exception e){
            e.printStackTrace();
        }
        return department;
    }
}
