package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long>{

  // @Query("SELECT gps_position FROM hospitals")
  // Iterable<Hospital> getHospitalsPositions();

}
