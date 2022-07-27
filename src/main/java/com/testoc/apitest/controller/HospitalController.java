package com.testoc.apitest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testoc.apitest.model.Hospital;
import com.testoc.apitest.model.Patient;
import com.testoc.apitest.model.Reservation;
import com.testoc.apitest.service.PatientService;
import com.testoc.apitest.service.HospitalService;
import com.testoc.apitest.service.ReservationService;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class HospitalController {

  @Autowired
  private HospitalService hospitalService;
  private PatientService patientService;
  private ReservationService reservationService;

  @GetMapping("/hospital/reserve_bed/{gps_position}")
  public Reservation reserve_bed(@RequestBody String gps_position, @RequestBody Patient patient){
    patient = patientService.savePatient(patient);

    // Iterable<Hospital>  hospitals_positions = hospitalService.getGps();
    //  //  WHERE h.id IN (SELECT * FROM DEPARTMENTS d WHERE d.type = ? AND d.id IN (SELECT DEPARTMENRT_ID  FROM ROOMS r WHERE r.beds.size >= 0 ))
    // System.out.println("coucou");
    // System.out.println(hospitals_positions);


    // String gps_positions = "-122.418563,37.751659;-122.422969,37.75529;-122.426904,37.75961";
    // String oc_token = "pk.eyJ1IjoiY29yZW50aW5ib3VyZGF0IiwiYSI6ImNsNXRpN2IwejA1enczamxhdmhmOWFoMmwifQ.zDWBYja68KwzSv5i6dGz-g";

    // String mapbox_url = String.format("https://api.mapbox.com/directions-matrix/v1/mapbox/walking/%s?sources=0&annotations=distance,duration&access_token=%s",gps_positions,oc_token);

    // var client = HttpClient.newHttpClient();
    // var request = HttpRequest.newBuilder(
    //        URI.create(mapbox_url))
    //    .header("accept", "application/json")
    //    .build();
    // var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
    //                      .thenApply(HttpResponse::body)
    //                      .join();



    // Iterable<Bed>  hospitals_positions = hospitalService.getGps();


    Reservation reservation = new Reservation();
    // reservation.setBedId(bed.ID);
    // reservation.setPatientId(patient.ID);
    // reservation.setStartDate(java.time.LocalTime.now());

    return reservation;

   }
}
