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

  public Optional<Hospital> getHospital(final Long id) {
    return hospitalRepository.findById(id);
  }

  public Iterable<Hospital> getHospitals() {
    return hospitalRepository.findAll();
  }

  public Iterable<Hospital> getGps() {
    return hospitalRepository.getHospitalsPositions();
  }

  public Iterable<Hospital> findByGpsPosition(String gps_position) {
    return hospitalRepository.whereGpsPosition(gps_position);
  }


  public void deleteHospital(final Long id) {
    hospitalRepository.deleteById(id);
  }

  public Hospital saveHospital(Hospital hospital) {
    Hospital savedHospital = hospitalRepository.save(hospital);
    return savedHospital;
  }

}
