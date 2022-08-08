// @ExtendWith(SpringExtension.class)
// @SpringBootTest
// class HospitalServiceTest {

//   @Autowired
//   private HospitalService hospitalService;

//   @Test
//   void getGps() {
//     Hospital firstHospital = new Hospital("CHU de Nantes Sud","47.1410204,-1.5329331", "chu.paris@gmail.com" );
//     Hospital savedFirstHospital = new Hospital(firstHospital);
//     Hospital secondHospital = new Hospital("CHU de Nantes Sud","47.1410132,-1.5329554", "chu.paris@gmail.com" );
//     Hospital savedSecondHospital = new Hospital(secondHospital);
//     String[] gpsPositions = {"47.1410204,-1.5329331", "47.1410132,-1.5329554"};
//     assertThat(hospitalService.getGps() == gpsPositions );
//   }

//   void findByGpsPosition() {
//     Hospital firstHospital = new Hospital("CHU de Nantes Sud","47.1410204,-1.5329331", "chu.paris@gmail.com" );
//     Hospital savedFirstHospital = new Hospital(firstHospital);
//     Hospital secondHospital = new Hospital("CHU de Nantes Sud","47.1410204,-1.5329331", "chu.paris@gmail.com" );
//     Hospital savedSecondHospital = new Hospital(secondHospital);

//     assertThat(hospitalService.findByGpsPosition("47.1410204,-1.5329331") == savedFirstHospital);
//   }

// }
