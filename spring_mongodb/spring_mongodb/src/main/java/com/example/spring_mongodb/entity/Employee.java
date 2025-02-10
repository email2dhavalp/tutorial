package com.example.spring_mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String emp_name;
    private String emp_city;
    private String emp_salary;

    public Employee() {
    }

    public Employee(String id, String emp_name, String emp_city, String emp_salary) {
        this.id = id;
        this.emp_name = emp_name;
        this.emp_city = emp_city;
        this.emp_salary = emp_salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_city() {
        return emp_city;
    }

    public void setEmp_city(String emp_city) {
        this.emp_city = emp_city;
    }

    public String getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(String emp_salary) {
        this.emp_salary = emp_salary;
    }
}
