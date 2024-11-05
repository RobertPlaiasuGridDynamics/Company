package com.example.demo.controllers;

import com.example.demo.entities.Department;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    public Iterable<Department> getDepartments(){
        return departmentService.getDepartments();
    }
}
