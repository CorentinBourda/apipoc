package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long>{

  @Query("FROM Department d WHERE d.hospitalId = ?1 and d.departmentType = ?2")
  Iterable<Department> byHospitalAndType(int hospitalId, String departmentType);

  // @Query("FROM Hospital h WHERE h.gpsPosition = ?1")
  // Iterable<Hospital> whereGpsPosition(String gpsPosition);
}
// FROM Department d WHERE d.hospitalId = ?1 and d.type = ?2
