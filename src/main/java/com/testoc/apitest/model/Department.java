package com.testoc.apitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "departments")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @HospitalId
  private Long HospitalId;

  @Type
  private Integer type;

}
