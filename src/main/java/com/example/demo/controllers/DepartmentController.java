package com.example.demo.controllers;

import com.example.demo.dtos.ReadDepartmentDto;
import com.example.demo.dtos.WriteDepartmentDto;
import com.example.demo.entities.Department;
import com.example.demo.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<ReadDepartmentDto>> getDepartments(){
        return new ResponseEntity<Iterable<ReadDepartmentDto>>(departmentService.getDepartments(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ReadDepartmentDto> createDepartment(@Valid @ModelAttribute WriteDepartmentDto departmentDto)
    {
        ReadDepartmentDto department = this.departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(department,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDepartment(@RequestParam("id") Long id)
    {
        this.departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Department with id " + id + " was deleted!",HttpStatus.OK);
    }
}
