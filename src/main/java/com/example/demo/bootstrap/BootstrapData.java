package com.example.demo.bootstrap;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Location;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

// @Component
public class BootstrapData implements CommandLineRunner {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private LocationRepository locationRepository;

    public BootstrapData(DepartmentRepository departmentRepository,
                         EmployeeRepository employeeRepository,
                         LocationRepository locationRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("1. JPA");
        Department finance = new Department("finance");
        departmentRepository.save(finance);

        Department it = new Department("it");
        departmentRepository.save(it);

        Iterable<Department> departments =departmentRepository.findAll();

        System.out.println("Departments : ");
        for (Department i : departments)
        {
            System.out.println(i.toString());
        }

        Location location1 = new Location("Bucharest","Bucharest");
        Location location2 = new Location("Iasi","Iasi");
        locationRepository.save(location1);
        locationRepository.save(location2);

        Iterable<Location> locations = locationRepository.findAll();

        System.out.println("Locations : ");
        for (Location i : locations)
        {
            System.out.println(i.toString());
        }


        Employee employee1 = new Employee("Marius","Marius","0760833236",
                "marius@marius.com",7000,"Str. Dumitru Cantemir",location1);


        employee1.setDepartments(it);
        Employee employee2 = new Employee("Marius2","Marius2","0760833236",
                "marius@marius.com",7000,"Str. Dumitru Cantemir 2",location2);

        Set<Department> departmentsEmployee2 = new HashSet<>(2);
        departmentsEmployee2.add(it);
        departmentsEmployee2.add(finance);

        employee2.setDepartments(departmentsEmployee2);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        Iterable<Employee> employees = employeeRepository.findAll();
        System.out.println("Employees : ");
        for(Employee i : employees) {
            System.out.println(i.toString());
        }

    }
}
