package com.example.spring_mongodb.repository;


import com.example.spring_mongodb.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    @Query("{emp_name:?0}")
    List<Employee> findByFirstName(String emp_name);

    @Query("{emp_name:?0, emp_city:?1}")
    List<Employee> findByFirstAndCity(String emp_name, String emp_city);

    @Query("{id: ?0}")
    @Update("{$set :  {emp_name : ?1}}")
    Integer update(String id, String employeeName);


}
