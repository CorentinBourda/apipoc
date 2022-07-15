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

@RestController
public class HospitalController {

  @Autowired
  private HospitalService hspitalService;

  /**
   * Create - Add a new employee
   * @param hospital An object employee
   * @return The employee object saved
   */
  @PostMapping("/hospital")
  public Hospital createHospital(@RequestBody Hospital hospital) {
    return hospitalService.savecHospital(hospital);
  }


  /**
   * Read - Get one employee
   * @param id The id of the employee
   * @return An Employee object full filled
   */
  @GetMapping("/hospital/{id}")
  public Hospital getHospital(@PathVariable("id") final Long id) {
    Optional<Hospital> hospital = hospitalService.getHospital(id);
    if(hospital.isPresent()) {
      return hospital.get();
    } else {
      return null;
    }
  }

  @GetMapping("/hospital/reccomand_hospital")
  public Hospital getHospital() {
    @RequestParam(required = true, defaultValue = "", value="gpsPosition") String gpsPosition
    @RequestParam(required = true, defaultValue = "", value="patientId") String patitentId




  }

  /**
   * Read - Get all employees
   * @return - An Iterable object of Employee full filled
   */
  @GetMapping("/hospital")
  public Iterable<Hospital> getHospitals() {
    return hospitalService.getHospitals();
  }

  /**
   * Update - Update an existing employee
   * @param id - The id of the employee to update
   * @param hospital - The employee object updated
   * @return
   */
  @PutMapping("/hospital/{id}")
  public Hospital updateHospital(@PathVariable("id") final Long id, @RequestBody Hospital hospital) {
    Optional<Hospital> e = hospitalService.getHospital(id);
    if(e.isPresent()) {
      Hospital currentHospital = e.get();

      String firstName = hospital.getFirstName();
      if(firstName != null) {
        currentHospital.setFirstName(firstName);
      }
      String lastName = hospital.getLastName();
      if(lastName != null) {
        currentHospital.setLastName(lastName);;
      }
      String mail = hospital.getMail();
      if(mail != null) {
        currentHospital.setMail(mail);
      }
      String password = hospital.getPassword();
      if(password != null) {
        currentHospital.setPassword(password);;
      }
      hospitalService.savecHospital(currentHospital);
      return currentHospital;
    } else {
      return null;
    }
  }


  /**
   * Delete - Delete an employee
   * @param id - The id of the employee to delete
   */
  @DeleteMapping("/hospital/{id}")
  public void deleteHospital(@PathVariable("id") final Long id) {
    hospitalService.deleteHospital(id);
  }


}
