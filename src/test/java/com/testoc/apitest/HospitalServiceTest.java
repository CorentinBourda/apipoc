package com.testoc.apitest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import com.testoc.apitest.model.Hospital;
import com.testoc.apitest.repository.HospitalRepository;
import com.testoc.apitest.service.HospitalService;
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
class HospitalServiceTest {

  // @MockBean
  // private HospitalRepository hospitalRepository;
  // @InjectMocks
  // private HospitalService hospitalService;

  @Autowired
  private HospitalRepository hospitalRepository;
  @Autowired
  private HospitalService hospitalService;


  @Test
  void testGetGps(){


    String[] gpsPositions = {"47.2108967,-1.5533024","47.1410204,-1.5329331"};
    assert gpsPositions[0].equals(hospitalService.getGps()[0]);
    assert gpsPositions[1].equals(hospitalService.getGps()[1]);
  }

  @Test
  void testFindByGpsPosition(){
    int hospitalId = 3;
    String gpsPosition = "47.175831,-1.624034";
    int foundId = hospitalService.findByGpsPosition(gpsPosition).getId();
    boolean assertion = (hospitalId == foundId);
    assert assertion;
  }

}
