@ExtendWith(SpringExtension.class)
@SpringBootTest
class DepartmentServiceTest {

  @Autowired
  private DepartmentService departmentService;

  @Test
  void findByHospitalAndType() {
    Hospital firstHospital = new Hospital("zaphod", "zaphod@mail.com");
    Hospital savedFirstHospital = new Hospital("zaphod", "zaphod@mail.com");
    Hospital secondHospital = new Hospital("zaphod", "zaphod@mail.com");
    Hospital savedSecondHospital = new Hospital("zaphod", "zaphod@mail.com");
    String type = "radiology";

    Department firstDepartment = new Department(type, savedFirstHospital);
    Department secondDepartment = new Department("traumatology",savedSecondHospital);
    Department thirdDepartment = new Department(type, savedSecondHospital);

    Department savedFirstDepartment = departmentService.saveDepartment(firstDepartment);
    Department savedSecondDepartment = departmentService.saveDepartment(secondDepartment);
    Department savedThirdDepartment = departmentService.saveDepartment(thirdDepartment);


    assertThat(departmentService.findByHospitalAndType(hospital, type)).isNotNull();
  }

}
