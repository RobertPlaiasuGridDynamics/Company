package com.example.demo.controllers;

import com.example.demo.dtos.ReadDepartmentDto;
import com.example.demo.entities.Department;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<ReadDepartmentDto>> getDepartments(){
        return new ResponseEntity<Iterable<ReadDepartmentDto>>(departmentService.getDepartments(), HttpStatus.OK);
    }
}
