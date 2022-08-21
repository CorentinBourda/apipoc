package com.testoc.apitest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testoc.apitest.model.Hospital;
import com.testoc.apitest.model.Patient;
import com.testoc.apitest.model.Reservation;
import com.testoc.apitest.model.Bed;
import com.testoc.apitest.model.Department;
import com.testoc.apitest.service.PatientService;
import com.testoc.apitest.service.HospitalService;
import com.testoc.apitest.service.ReservationService;
import com.testoc.apitest.service.BedService;
import com.testoc.apitest.service.DepartmentService;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.InetAddress;

import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.core.convert.converter.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@RestController
public class HospitalController {

  @Autowired
  private HospitalService hospitalService;

  @Autowired
  private PatientService patientService;

  @Autowired
  private ReservationService reservationService;

  @Autowired
  private BedService bedService;

  @Autowired
  private DepartmentService departmentService;

  @GetMapping("/hospital/reserve_bed")
  public Reservation reserveBed(@RequestBody Patient patient, @RequestParam("gps_position") String gpsPosition, @RequestParam("department_type") String departmentType){

    Patient savedPatient = patientService.savePatient(patient);

    String[]  hospitalsPositions = hospitalService.getGps();
    System.out.println(hospitalsPositions);
    System.out.println(gpsPosition);
    String stringGpsPositions =  String.join(";", hospitalsPositions);
    stringGpsPositions = gpsPosition + ";" + stringGpsPositions;
    // String gps_positions = "-122.418563,37.751659;-122.422969,37.75529;-122.426904,37.75961";

    String ocToken = System.getenv("MAPBOX_TOKEN");

    String mapboxUrl = String.format("https://api.mapbox.com/directions-matrix/v1/mapbox/driving/%s?sources=0&annotations=duration&access_token=%s",stringGpsPositions,ocToken);

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder(
           URI.create(mapboxUrl))
       .header("accept", "application/json")
       .build();
    String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                         .thenApply(HttpResponse::body)
                         .join();
    JSONObject hash = new JSONObject(response);
    System.out.println("hash");
    System.out.println(ocToken);
    System.out.println(hash);
    JSONArray distances = hash.getJSONArray("durations").getJSONArray(0);

    int nearestDistance = distances.getInt(0);
    int nearestDistancePosition = 0;
    int number = 0;

    for(int i = 0 ; i < distances.length() ; i++){
      number = distances.getInt(i);
      if (number <= nearestDistance && number != 0) {
        nearestDistance = number;
        nearestDistancePosition = i;

      }
      i = i + 1;
    }

    String nearestHospitalPosition = hospitalsPositions[nearestDistancePosition];
    Hospital nearestHospital = hospitalService.findByGpsPosition(nearestHospitalPosition);
    System.out.println(nearestHospital.id);
    System.out.println(departmentType);
    Department department = departmentService.findByHospitalAndType(nearestHospital.id, departmentType);

    Bed usableBed = bedService.getBed(department.id);
    String ocToken = System.getenv("HOSTNAME");

    Reservation reservation = new Reservation();
    reservation.setBedId(usableBed.id);
    reservation.setPatientId(savedPatient.getId());
    reservation.setStartDate(java.time.LocalDateTime.now());
    reservation.setHostName(hostName);
    Reservation savedReservation = reservationService.saveReservation(reservation);

    return reservation;

   }

  @GetMapping("/hospital/get_hospital")
  public Hospital get_hospital(){

    Hospital hospital = hospitalService.findFirstHospital();
    return hospital;

   }
}
