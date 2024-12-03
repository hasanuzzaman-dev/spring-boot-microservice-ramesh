package com.hasan.departmentservice.repository;

import com.hasan.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  DepartmentRepository extends JpaRepository<Department, Long> {
}
