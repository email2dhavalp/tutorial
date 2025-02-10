package com.example.spring_mongodb.controller;


import com.example.spring_mongodb.entity.Employee;
import com.example.spring_mongodb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/save")
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @GetMapping(value = "get/{id}")
    @ResponseBody
    public Optional<Employee> get(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping(value = "delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping(value = "/name")
    @ResponseBody
    public List<Employee> getByName(@RequestParam String name) {
        return employeeService.findByEmployeeName(name);
    }

    @GetMapping(value = "/name-city")
    @ResponseBody
    public List<Employee> getByName(@RequestParam String name, @RequestParam String city) {
        return employeeService.findByNameAndCity(name, city);
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Integer update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

}
