package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Bed;

@Repository
public interface BedRepository extends CrudRepository<Bed, Long>{

}
