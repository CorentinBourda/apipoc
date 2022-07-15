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
@Table(name = "reservations")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @ManyToOne
  @JoinColumn(name="bed_id")
  private Bed bed;

  @ManyToOne
  @JoinColumn(name="patient_id")
  private Patient patient;

  @StartDate
  private Date StartDate;

  @EndDate
  private Date EndDate;

}
