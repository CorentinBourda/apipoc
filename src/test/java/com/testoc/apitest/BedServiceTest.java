@ExtendWith(SpringExtension.class)
@SpringBootTest
class BedServiceTest {

  @Autowired
  private BedService bedService;

  @Test
  void getBed() {
    Bed user = new User("zaphod", "zaphod@mail.com");
    User savedUser = bedService.registerUser(user);
    assertThat(savedUser.getRegistrationDate()).isNotNull();
  }

}
