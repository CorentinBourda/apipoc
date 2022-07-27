package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long>{

  // @Query("SELECT * FROM hospitals")
  // Iterable<Hospital> getHospitalsPositions(String department_type);

  @Query("select h.gps_position from Hospital h")
  Iterable<Hospital> getHospitalsPositions(String department_type);


  @Query("select h from Hospital h where h.gps_position = ?")
  Iterable<Hospital> whereGpsPosition(String gps_position);

  // public Iterable<Hospital> getHospitalsPositions(String department_type) {
  //   return @Query("SELECT * FROM hospitals");
  // }

}
