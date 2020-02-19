package com.spring.app.service;


import com.spring.app.pojo.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Flux<Employee> findAll();

    Mono<Employee> insert(Employee employee);

    Mono<Employee> findById(String employeeId);

    Mono<Long> delete(String employeeId);

}
