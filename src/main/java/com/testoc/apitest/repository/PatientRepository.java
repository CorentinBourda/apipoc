package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long>{

}
