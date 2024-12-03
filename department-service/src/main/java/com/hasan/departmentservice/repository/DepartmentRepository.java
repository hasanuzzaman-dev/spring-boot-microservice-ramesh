package com.hasan.departmentservice.repository;

import com.hasan.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String code);
}
