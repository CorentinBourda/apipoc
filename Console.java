// import java.io.IOException;
// import java.io.InputStream;
// import java.net.HttpURLConnection;
// import java.net.URL;
// import java.net.URI;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;

// import java.util.regex.Matcher;
// import java.util.regex.Pattern;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testoc.apitest.model.Hospital;
import com.testoc.apitest.model.Patient;
import com.testoc.apitest.model.Reservation;
import com.testoc.apitest.model.Bed;
import com.testoc.apitest.model.Department;
import com.testoc.apitest.service.PatientService;
import com.testoc.apitest.service.HospitalService;
import com.testoc.apitest.service.ReservationService;
import com.testoc.apitest.service.BedService;
import com.testoc.apitest.service.DepartmentService;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;
import org.json.JSONArray;


public class Console {

  @Autowired
  private HospitalService hospitalService;
  private PatientService patientService;
  private ReservationService reservationService;
  private BedService bedService;
  private DepartmentService departmentService;

  public static void main(String[] args) throws Exception {
    // String gps_positions = "-122.418563,37.751659;-122.422969,37.75529;-122.426904,37.75961";
    // String oc_token = "pk.eyJ1IjoiY29yZW50aW5ib3VyZGF0IiwiYSI6ImNsNXRpN2IwejA1enczamxhdmhmOWFoMmwifQ.zDWBYja68KwzSv5i6dGz-g";

    // String mapbox_url = String.format("https://api.mapbox.com/directions-matrix/v1/mapbox/walking/%s?sources=0&annotations=distance,duration&access_token=%s",gps_positions,oc_token);

    // var client = HttpClient.newHttpClient();
    // var request = HttpRequest.newBuilder(
    //        URI.create(mapbox_url))
    //    .header("accept", "application/json")
    //    .build();
    // var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
    //                      .thenApply(HttpResponse::body)
    //                      .join();
    // System.out.println(response);

    // var = Pattern.compile("\"durations\":[[(.*)]]");
    // var m = p.matcher(response);
    Hospital nearest_hospital = hospitalService.findByGpsPosition(nearest_position);

    System.out.println(nearest_hospital);

    // Logique pour trouver le plus petit nb
    // int[] numbers = {10, 9, 5, -2};

    // // for each loop
    // var i = 0;
    // var min = numbers[0];
    // for (int number: numbers) {
    //   if (number <= min) {
    //     min = number;
    //   }
    //   i = i + 1;
    // }
    //  System.out.println(min);
  }

}
