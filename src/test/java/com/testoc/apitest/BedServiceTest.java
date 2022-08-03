@ExtendWith(SpringExtension.class)
@SpringBootTest
class BedServiceTest {

  @Autowired
  private BedService bedService;
  private DepartmentService departmentService;
  private HospitalService hospitalService;


  @Test
  void getBed() {
    Hospital firstHospital = new Hospital('CHU de Nantes Sud','47.1410204,-1.5329331', 'chu.paris@gmail.com' );
    Hospital savedFirstHospital = hospitalService.saveHospital(firstHospital);
    Hospital secondHospital = new Hospital('CHU de Nantes Sud','47.1410204,-1.5329331', 'chu.paris@gmail.com' );
    Hospital savedSecondHospital = hospitalService.saveHospital(secondHospital);

    Department firstDepartment = new Department("radiology", savedFirstHospital);
    Department secondDepartment = new Department("traumatology",savedSecondHospital);
    Department thirdDepartment = new Department("radiology", savedSecondHospital);

    Department savedFirstDepartment = departmentService.saveDepartment(firstDepartment);
    Department savedSecondDepartment = departmentService.saveDepartment(secondDepartment);
    Department savedThirdDepartment = departmentService.saveDepartment(thirdDepartment);

    Bed firstBed = new Bed(savedFirstDepartment);
    Bed secondBed = new Bed(savedSecondDepartment);
    Bed thirdBed = new Bed(savedThirdDepartment);
    Bed savedFirstBed = bedService.saveBed(firstBed);
    Bed savedSecondBed = bedService.saveBed(secondBed);
    Bed savedThirdBed = bedService.saveBed(thirdBed);

    assertThat(bedService.getBed(savedFirstDepartment)[0] == savedFirstBed);
  }

}
