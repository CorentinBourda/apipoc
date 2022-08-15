package com.testoc.apitest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testoc.apitest.model.Patient;
import com.testoc.apitest.repository.PatientRepository;

import lombok.Data;

@Data
@Service
public class PatientService {

  @Autowired
  private PatientRepository patientRepository;

  public Patient savePatient(Patient patient) {
    Patient savedPatient = patientRepository.save(patient);
    return savedPatient;
  }

}
