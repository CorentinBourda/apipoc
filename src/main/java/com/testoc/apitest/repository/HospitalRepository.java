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

  @Query("SELECT h.gpsPosition FROM Hospital h")
  Iterable<Hospital> getHospitalsPositions();


  @Query("FROM Hospital h WHERE h.gpsPosition = ?1")
  Iterable<Hospital> whereGpsPosition(String gpsPosition);

  // public Iterable<Hospital> getHospitalsPositions(String department_type) {
  //   return @Query("SELECT * FROM hospitals");
  // }

}
