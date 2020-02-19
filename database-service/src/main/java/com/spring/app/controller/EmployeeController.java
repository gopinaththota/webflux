package com.spring.app.controller;


import com.spring.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.spring.app.pojo.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Mono<Employee> saveEmployeeDetails(@RequestBody Employee employee) {
        return employeeService.insert(employee);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> getEmployeeDetails() {
        System.out.println("Entered into the search() method");
        return employeeService.findAll();
    }

    @RequestMapping(value = "/view/{employeeId}", method = RequestMethod.GET)
    public Mono<Employee> viewEmployeeDetails(@PathVariable("employeeId") String employeeId) {
        return employeeService.findById(employeeId);
    }

    @RequestMapping(value = "/delete/{employeeId}", method = RequestMethod.GET)
    public Mono<Long> deleteEmployeeDetails(@PathVariable("employeeId") String employeeId) {
        return employeeService.delete(employeeId);
    }
}