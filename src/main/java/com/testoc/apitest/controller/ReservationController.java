kage com.testoc.apitest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testoc.apitest.model.Reservation;
import com.testoc.apitest.service.ReservationService;

@RestController
public class ReservationController {

  @Autowired
  private ReservationService reservationService;

  /**
   * @param reservation
   * @return
   */
  @PostMapping("/reservation")
  public Reservation createReservation(@RequestBody Reservation reservation) {
    return reservationService.saveReservation(reservation);
  }
}
