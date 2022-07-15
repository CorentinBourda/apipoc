package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
