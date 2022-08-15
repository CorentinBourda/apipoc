package com.testoc.apitest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import com.testoc.apitest.model.Patient;
import com.testoc.apitest.repository.PatientRepository;
import com.testoc.apitest.service.PatientService;
import org.assertj.core.util.Arrays;
import org.hibernate.mapping.Array;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// @ExtendWith(MockitoExtension.class)
// @ExtendWith(SpringExtension.class)
@SpringBootTest
class PatientServiceTest {

  // @MockBean
  // private HospitalRepository hospitalRepository;
  // @InjectMocks
  // private HospitalService hospitalService;

  @Autowired
  private PatientRepository patientRepository;
  @Autowired
  private PatientService patientService;


  @Test
  void testSavePatient(){

    Patient patient = new Patient();
    patient.setFirstName("Corentin");
    patient.setLastName("Bourdat");

    Patient firstSavedPatient = patientService.savePatient(patient);
    int id = 1;
    boolean firstAssertion = id ==  firstSavedPatient.getId();

    assert firstAssertion;

  }


}
