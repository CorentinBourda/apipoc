package com.testoc.apitest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.testoc.apitest.model.Bed;
import com.testoc.apitest.repository.BedRepository;

import lombok.Data;

@Data
@Service
public class BedService {

  @Autowired
  private BedRepository bedRepository;

  public Iterable<Bed> getBeds() {
    return bedRepository.findAll();
  }
}
