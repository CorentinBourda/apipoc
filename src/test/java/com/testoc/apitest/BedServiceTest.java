package com.testoc.apitest;

import static org.hamcrest.CoreMatchers.is;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

import com.testoc.apitest.repository.BedRepository;
import com.testoc.apitest.service.BedService;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// @ExtendWith(MockitoExtension.class)
// @ExtendWith(SpringExtension.class)
@SpringBootTest
class BedServiceTest {

  @Autowired
  private BedRepository bedRepository;

  @Autowired
  private BedService bedService;


  @Test
  void getBed() {
    int firstBedId = 1;
    int secondBedId = 9;

    int firstDepartmentId = 1;
    int secondDepartmentId = 3;

    int firstFoundBedId = bedService.getBed(firstDepartmentId).getId();
    boolean firstAssertion = (firstFoundBedId == firstBedId);

    assert firstAssertion;

    int secondFoundBedId = bedService.getBed(secondDepartmentId).getId();
    boolean secondAssertion = (secondFoundBedId == secondBedId);
    System.out.println("nearestDistance");
    System.out.println(secondFoundBedId);
    assert secondAssertion;

  }

}
