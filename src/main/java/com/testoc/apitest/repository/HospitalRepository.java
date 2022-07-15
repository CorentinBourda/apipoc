package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
