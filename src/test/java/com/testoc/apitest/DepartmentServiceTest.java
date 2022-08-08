// @ExtendWith(SpringExtension.class)
// @SpringBootTest
// class DepartmentServiceTest {

//   @Autowired
//   private DepartmentService departmentService;

//   @Test
//   void findByHospitalAndType() {
//     Hospital firstHospital = new Hospital("CHU de Nantes Sud","47.1410204,-1.5329331", "chu.paris@gmail.com" );
//     Hospital savedFirstHospital = new Hospital(firstHospital);
//     Hospital secondHospital = new Hospital("CHU de Nantes Sud","47.1410204,-1.5329331", "chu.paris@gmail.com" );
//     Hospital savedSecondHospital = new Hospital(secondHospital);
//     String type = "radiology";

//     Department firstDepartment = new Department(type, savedFirstHospital);
//     Department secondDepartment = new Department("traumatology",savedSecondHospital);
//     Department thirdDepartment = new Department(type, savedSecondHospital);

//     Department savedFirstDepartment = departmentService.saveDepartment(firstDepartment);
//     Department savedSecondDepartment = departmentService.saveDepartment(secondDepartment);
//     Department savedThirdDepartment = departmentService.saveDepartment(thirdDepartment);


//     assertThat(departmentService.findByHospitalAndType(hospital, type)[0] == savedFirstDepartment);
//   }

// }
