package com.spring.app.serviceImpl;

import com.spring.app.pojo.Employee;
import com.spring.app.repository.EmployeeRepository;
import com.spring.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Mono<Employee> insert(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Mono<Employee> findById(String employeeId) {
        return employeeRepository.findById(Integer.parseInt(employeeId));
    }

    @Override
    public Mono<Long> delete(String employeeId) {
        return employeeRepository.deleteById(Integer.parseInt(employeeId));
    }
}
