package com.example.demo.services;


import com.example.demo.dtos.ReadDepartmentDto;
import com.example.demo.dtos.WriteDepartmentDto;
import com.example.demo.entities.Department;
import org.springframework.stereotype.Service;

public interface DepartmentService {

    Iterable<ReadDepartmentDto> getDepartments();

    ReadDepartmentDto saveDepartment(WriteDepartmentDto department);

    void deleteDepartment(Long departmentId);

}
