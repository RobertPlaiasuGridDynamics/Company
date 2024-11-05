package com.example.demo.services;


import com.example.demo.entities.Department;
import org.springframework.stereotype.Service;

public interface DepartmentService {

    Iterable<Department> getDepartments();

    Department saveDepartment(Department department);

    void deleteDepartment(Long departmentId);

}
