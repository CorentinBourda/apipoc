@ExtendWith(SpringExtension.class)
@SpringBootTest
class DepartmentServiceTest {

  @Autowired
  private DepartmentService departmentService;

  @Test
  void findByHospitalAndType() {
    Hospital hospital = new Hospital("zaphod", "zaphod@mail.com");
    User savedUser = bedService.registerUser(user);
    assertThat(savedUser.getRegistrationDate()).isNotNull();
  }

}
