package com.testoc.apitest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testoc.apitest.model.Department;
import com.testoc.apitest.repository.DepartmentRepository;

import lombok.Data;

@Data
@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  public Iterable<Department> getDepartments() {
    return departmentRepository.findAll();
  }

  // public Iterable<Department> findByHospitalAndType() {
  //   return departmentRepository.ByHospitalAndType();
  // }
}
