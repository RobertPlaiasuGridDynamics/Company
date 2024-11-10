package com.example.demo.dtos;

public class ReadDepartmentDto {

    private Long id;

    private String name;


    public ReadDepartmentDto() {
        super();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
