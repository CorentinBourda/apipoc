package com.testoc.apitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.core.convert.converter.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.net.InetAddress;

import lombok.Data;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="bed_id")
  private int BedId;

  @Column(name="patient_id")
  private int PatientId;

  @Column(name="start_date",columnDefinition="TIMESTAMP")
  private LocalDateTime startDate;

  @Column(name="end_date",columnDefinition="TIMESTAMP")
  private LocalDateTime endDate;

  @Column(name="host_name")
  private String hostName;

}
