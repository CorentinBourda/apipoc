@ExtendWith(SpringExtension.class)
@SpringBootTest
class PatientServiceTest {

  @Autowired
  private PatientService patientService;

  @Test
  void getPatient() {
    User user = new User("zaphod", "zaphod@mail.com");
    User savedUser = registerUseCase.registerUser(user);
    assertThat(savedUser.getRegistrationDate()).isNotNull();
  }

  void savePatient() {
    User user = new User("zaphod", "zaphod@mail.com");
    User savedUser = registerUseCase.registerUser(user);
    assertThat(savedUser.getRegistrationDate()).isNotNull();
  }

}
