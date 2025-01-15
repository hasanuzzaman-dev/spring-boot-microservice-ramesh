package com.hasan.departmentservice.contoller;

import com.hasan.departmentservice.dto.DepartmentDto;
import com.hasan.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedData = departmentService.save(departmentDto);

        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departmentDtos = departmentService.findAll();
        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
    }

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String code) {
        DepartmentDto departmentDto = departmentService.findByDepartmentCode(code);

        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
