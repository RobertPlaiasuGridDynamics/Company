package com.example.demo.services;

import com.example.demo.dtos.ReadDepartmentDto;
import com.example.demo.dtos.WriteDepartmentDto;
import com.example.demo.entities.Department;
import com.example.demo.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class DepartmentJPAService implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<ReadDepartmentDto> getDepartments() {
        return StreamSupport
                .stream(departmentRepository.findAll().spliterator(),false)
                .map(t -> this.modelMapper.map(t,ReadDepartmentDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public ReadDepartmentDto saveDepartment(WriteDepartmentDto department) {
        return null;
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
