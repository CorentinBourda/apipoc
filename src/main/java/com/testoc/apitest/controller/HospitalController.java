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
import com.testoc.apitest.service.PatientService;
import com.testoc.apitest.service.HospitalService;

@RestController
public class HospitalController {

  @Autowired
  private HospitalService hospitalService;

  @GetMapping("/hospital/reserve_bed/{gps_position}")
  public Hospital reserve_bed(@PathVariable("gps_position") final Long id, @RequestBody Patient patient){
    patient = patientService.savePatient(patient);


    // possible de calculer les iténéraires en 1 seul appel
    oc_token = "pk.eyJ1IjoiY29yZW50aW5ib3VyZGF0IiwiYSI6ImNsNXRpN2IwejA1enczamxhdmhmOWFoMmwifQ.zDWBYja68KwzSv5i6dGz-g"

    hospitals_positions = @Query(
      "SELECT gps_position FROM HOSPITALS h WHERE h.id IN (SELECT * FROM DEPARTMENTS d WHERE d.type = ? AND d.id IN (SELECT DEPARTMENRT_ID  FROM ROOMS r WHERE r.beds.size >= 0 ))");

    mapbox_url = $"https://api.mapbox.com/directions-matrix/{String.join(",", hospitals_positions)}/&access_token={oc_token}/v1/";

    URL url = new URL(mapbox_url);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    bed = @Query(
      "SELECT * FROM BEDS b WHERE DEPARTMENRT_ID IN (SELECT DEPARTMENT)")


    var reservation = new Reservation();
    reservation.setBedId(bed.ID);
    reservation.setPatientId(patient.ID);
    reservation.setStartDate(java.time.LocalTime.now());
    reservation.setStartDate(java.time.LocalTime.now().plusDays(1));


    return

  }
}
