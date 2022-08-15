package com.testoc.apitest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

import com.testoc.apitest.model.Department;
import com.testoc.apitest.repository.DepartmentRepository;
import com.testoc.apitest.service.DepartmentService;
import org.assertj.core.util.Arrays;
import org.hibernate.mapping.Array;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;

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
class DepartmentServiceTest {

  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private DepartmentService departmentService;


  @Test
  void testFindByHospitalAndType(){

    int firstHopitalId = 1;
    int secondHopitalId = 2;

    String firstType = "radiologie";
    String secondType = "réanimation";

    Department firstDepartment = departmentService.findByHospitalAndType(firstHopitalId, firstType);
    Department secondDepartment = departmentService.findByHospitalAndType(secondHopitalId, secondType);

    boolean firstAssertion = firstDepartment.getId() == 1;
    boolean secondAssertion = secondDepartment.getId() == 2;
    assert firstAssertion;
    assert secondAssertion;
  }


}
