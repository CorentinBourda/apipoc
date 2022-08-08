package com.testoc.apitest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testoc.apitest.model.Bed;

@Repository
public interface BedRepository extends CrudRepository<Bed, Long>{

  @Query("FROM Bed b WHERE b.roomId IN (SELECT r.id FROM Room r WHERE r.departmentId = ?1 )")
  Iterable<Bed> findByDepartmentId(int departmentId);

}
