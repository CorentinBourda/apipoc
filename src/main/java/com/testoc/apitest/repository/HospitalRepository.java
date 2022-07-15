package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long>{

}
