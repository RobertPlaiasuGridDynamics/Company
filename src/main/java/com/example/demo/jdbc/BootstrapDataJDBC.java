package com.example.demo.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// @Component
public class BootstrapDataJDBC implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        BootstrapTables.createTables();
        BootstrapTables.insertRowLocations("Bucharest","Bucharest");
        BootstrapTables.locations();
    }
}
