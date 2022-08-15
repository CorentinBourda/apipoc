package com.testoc.apitest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import com.testoc.apitest.model.Reservation;
import com.testoc.apitest.repository.ReservationRepository;
import com.testoc.apitest.service.ReservationService;
import org.assertj.core.util.Arrays;
import org.hibernate.mapping.Array;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;
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
class ReservationServiceTest {

  // @MockBean
  // private HospitalRepository hospitalRepository;
  // @InjectMocks
  // private HospitalService hospitalService;

  @Autowired
  private ReservationRepository reservationRepository;
  @Autowired
  private ReservationService reservationService;


  @Test
  void testSaveReservationWithPatient(){

    Reservation reservation = new Reservation();
    reservation.setBedId(1);
    reservation.setStartDate(java.time.LocalDateTime.now());

    Reservation firstSavedReservation = reservationService.saveReservation(reservation);
    int id = 1;
    boolean firstAssertion = id ==  firstSavedReservation.getId();

    assert firstAssertion;

  }


}
