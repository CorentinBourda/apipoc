package com.testoc.apitest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testoc.apitest.model.Reservation;
import com.testoc.apitest.repository.ReservationRepository;

import lombok.Data;

@Data
@Service
public class ReservationService {

  @Autowired
  private ReservationRepository reservationRepository;

  // public Optional<Reservation> getReservation(final Long id) {
  //   return reservationRepository.findById(id);
  // }

  // public Iterable<Reservation> getReservations() {
  //   return reservationRepository.findAll();
  // }

  // public void deleteReservation(final Long id) {
  //   reservationRepository.deleteById(id);
  // }

  public Reservation saveReservation(Reservation reservation) {
    Reservation savedReservation= reservationRepository.save(reservation);
    return savedReservation;
  }

}
