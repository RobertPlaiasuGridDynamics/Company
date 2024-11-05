package com.example.demo.jdbc;

import java.sql.*;

import static com.example.demo.jdbc.DatabaseConnection.*;

public class BootstrapTables {

    private static String createTableDepartments()
    {
        return "CREATE TABLE departments(" +
                " id IDENTITY NOT NULL PRIMARY KEY , " +
                " name varchar(255) not null);";
    }

    private static String createTableLocations()
    {
        return "CREATE TABLE locations(" +
                " id IDENTITY NOT NULL PRIMARY KEY , " +
                " region varchar(255) not null, " +
                " city varchar(255) not null);";
    }

    private static String createTableEmployees()
    {
        return "CREATE TABLE employees(" +
                " id IDENTITY NOT NULL PRIMARY KEY, " +
                " firstName varchar(255) not null, " +
                " lastName varchar(255) not null, " +
                " phoneNumber varchar(255) not null, " +
                " email varchar(255) not null, " +
                " address varchar(255) not null, " +
                " salary integer not null, " +
                " locationId integer not null, " +
                " foreign key (locationId) references locations(id));";
    }

    private static String createTableDepartmentsEmployees()
    {
        return "CREATE TABLE departments_employees(" +
                " departmentId integer not null, " +
                " employeeId integer not null, " +
                " foreign key (departmentId) references departments(id), "  +
                " foreign key (employeeId) references employees(id), " +
                " primary key (employeeId,departmentId))";
    }

    public static void locations()
    {
        try{
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            String query = "select id,region,city from locations";

            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                System.out.println("Locations : ");
                System.out.print(" Id: " + rs.getInt(1));
                System.out.print(" Region: " + rs.getString(2));
                System.out.println(" City: " + rs.getString(3));
            }

            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertRowLocations(String region,String city)
    {
        Connection conn = null;
        Statement stmt = null;
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);


            // STEP 3: Execute a query
            stmt = conn.createStatement();

            stmt.executeUpdate("insert into locations(region,city) values(' " + region + " ','" +city+ "')");


            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        }
    }

    public static void createTables() {
        // Open a connection
        Connection conn = null;
        Statement stmt = null;
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL,USER,PASS);


            // STEP 3: Execute a query
            stmt = conn.createStatement();
            stmt.execute("DROP table if exists departments_employees");
            stmt.execute("DROP table if exists employees");
            stmt.execute("DROP table if exists departments");
            stmt.execute("DROP table if exists locations");
            stmt.execute(createTableLocations());
            stmt.execute(createTableDepartments());
            stmt.execute(createTableEmployees());
            stmt.execute(createTableDepartmentsEmployees());




            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}

