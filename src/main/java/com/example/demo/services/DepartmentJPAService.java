package com.example.demo.services;

import com.example.demo.entities.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentJPAService implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Iterable<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
