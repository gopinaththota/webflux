package com.spring.app.repository;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.app.pojo.Employee;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
    public Flux<Employee> findAll();

    @Query("{ 'id': ?0}")
    public Mono<Employee> findById(int id);

    @Query(value="{id : ?0}", delete = true)
    public Mono<Long> deleteById(int id);
}
