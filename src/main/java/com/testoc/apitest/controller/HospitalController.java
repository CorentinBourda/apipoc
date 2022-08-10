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

import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.core.convert.converter.Converter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@RestController
public class HospitalController {

  @Autowired
  private HospitalService hospitalService;
  private PatientService patientService;
  private ReservationService reservationService;
  private BedService bedService;
  private DepartmentService departmentService;

  @GetMapping("/hospital/reserve_bed")
  public Reservation reserveBed(@RequestBody Patient patient, @PathVariable("gps_position") String gpsPosition, @PathVariable("department_type") String departmentType){
    patient = patientService.savePatient(patient);

    String[]  hospitalsPositions = hospitalService.getGps();
    System.out.println(hospitalsPositions);
    String stringGpsPositions =  String.join(";", hospitalsPositions);
    stringGpsPositions = gpsPosition + stringGpsPositions;
    // String gps_positions = "-122.418563,37.751659;-122.422969,37.75529;-122.426904,37.75961";
    System.out.println("coucou2");
    System.out.println(stringGpsPositions);


    String oc_token = System.getenv("MAPBOX_TOKEN");

    String mapboxUrl = String.format("https://api.mapbox.com/directions-matrix/v1/mapbox/walking/%s?sources=0&annotations=distance,duration&access_token=%s",stringGpsPositions,oc_token);
    System.out.println("coucou3");
    System.out.println(mapboxUrl);

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
    System.out.println(hash);
    JSONArray distances = hash.getJSONArray("durations").getJSONArray(0);
    System.out.println("distances");
    System.out.println(distances);

    int nearestDistance = distances.getInt(0);
    int nearestDistancePosition = 0;
    int number = 0;

    for(int i = 0 ; i < distances.length() ; i++){
      number = distances.getInt(i);
      if (number <= nearestDistance) {
        nearestDistance = number;
        nearestDistancePosition = i;

      }
      i = i + 1;
    }
    System.out.println("nearestDistance");
    System.out.println(nearestDistance);
    System.out.println("nearestDistancePosition");
    System.out.println(nearestDistancePosition);

    String nearestHospitalPosition = hospitalsPositions[nearestDistancePosition];
    Hospital nearestHospital = hospitalService.findByGpsPosition(nearestHospitalPosition);

    Department department = departmentService.findByHospitalAndType(nearestHospital.id, departmentType);

    Bed usableBed = bedService.getBed(department.id);

    Reservation reservation = new Reservation();
    reservation.setBedId(usableBed.id);
    reservation.setPatientId(patient.id);
    reservation.setStartDate(java.time.LocalDateTime.now());
    Reservation savedReservation = reservationService.saveReservation(reservation);

    return reservation;

   }

  @GetMapping("/hospital/get_hospital")
  public Hospital get_hospital(@PathVariable("gps_position") String gpsPosition){
    Hospital hospital = hospitalService.findFirstHospital();
    return hospital;

   }
}
