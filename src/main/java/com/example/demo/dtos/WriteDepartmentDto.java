package com.example.demo.dtos;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WriteDepartmentDto {

    @NotBlank(message = "Name is empty!")
    @Size(min = 2,max = 100,message = "Name should have between 2 and 100 characters !")
    private String name;

    public WriteDepartmentDto()
    {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
