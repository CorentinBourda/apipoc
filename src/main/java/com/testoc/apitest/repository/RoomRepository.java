package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

}
