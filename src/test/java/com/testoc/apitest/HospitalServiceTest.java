@ExtendWith(SpringExtension.class)
@SpringBootTest
class HospitalServiceTest {

  @Autowired
  private HospitalService hospitalService;

  @Test
  void getGps() {
    User user = new User("zaphod", "zaphod@mail.com");
    User savedUser = registerUseCase.registerUser(user);
    assertThat(savedUser.getRegistrationDate()).isNotNull();
  }

  void findByGpsPosition() {
    User user = new User("zaphod", "zaphod@mail.com");
    User savedUser = registerUseCase.registerUser(user);
    assertThat(savedUser.getRegistrationDate()).isNotNull();
  }

}
