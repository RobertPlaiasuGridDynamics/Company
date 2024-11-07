package com.example.demo.dtos;

public class ReadDepartmentDto {

    private Integer id;

    private String name;


    public ReadDepartmentDto() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
