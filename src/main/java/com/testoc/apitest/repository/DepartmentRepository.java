package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{

  // @Query("select h.gps_position from Hospitals h")
  // Iterable<Department> ByHospitalAndType();
}
