package com.hasan.employeeservice.service;

import com.hasan.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/*

 TODO: If there are multiple instance then it should be provide only name of the service
       for load balancing. Eureka service provide load balancing internally
*/

//@FeignClient(name = "DEPARTMENT-SERVICE", url = "http://localhost:8080")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("/api/departments/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String code);
}
