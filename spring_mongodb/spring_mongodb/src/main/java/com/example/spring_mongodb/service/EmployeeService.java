package com.example.spring_mongodb.service;

import com.example.spring_mongodb.entity.Employee;
import com.example.spring_mongodb.repository.EmployeeRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public void deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findByEmployeeName(String employeeName) {
        return employeeRepository.findByFirstName(employeeName);
    }

    public List<Employee> findByNameAndCity(String employeeName, String city) {
        return employeeRepository.findByFirstAndCity(employeeName, city);
    }

    public Integer update(Employee employee) {
        return employeeRepository.update(employee.getId(), employee.getEmp_name());

    }

//    public Employee update(Employee employee) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("id").is(employee.getId()));
//        Update update = new Update();
//        update.set("emp_name", employee.getEmp_name());
//        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017/employees");
//        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "mytestdb");
//        return mongoTemplate.findAndModify(query, update, Employee.class);
//
//    }

}
