package com.testoc.apitest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testoc.apitest.model.Hospital;
import com.testoc.apitest.repository.HospitalRepository;

import lombok.Data;

@Data
@Service
public class HospitalService {

  @Autowired
  private HospitalRepository hospitalRepository;

  public String[] getGps() {
    return hospitalRepository.getHospitalsPositions();
  }

  public Hospital findFirstHospital() {
    return hospitalRepository.findAll().iterator().next();
  }

  public Hospital findByGpsPosition(String gpsPosition) {
    return hospitalRepository.whereGpsPosition(gpsPosition).iterator().next();
  }

}
