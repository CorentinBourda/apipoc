import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Console {

  public static void main(String[] args) throws Exception {
    String gps_positions = "-122.418563,37.751659;-122.422969,37.75529;-122.426904,37.75961";
    String oc_token = "pk.eyJ1IjoiY29yZW50aW5ib3VyZGF0IiwiYSI6ImNsNXRpN2IwejA1enczamxhdmhmOWFoMmwifQ.zDWBYja68KwzSv5i6dGz-g";

    String mapbox_url = String.format("https://api.mapbox.com/directions-matrix/v1/mapbox/walking/%s?sources=0&annotations=distance,duration&access_token=%s",gps_positions,oc_token);

    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(
           URI.create(mapbox_url))
       .header("accept", "application/json")
       .build();
    var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                         .thenApply(HttpResponse::body)
                         .join();
    System.out.println(response);

    var = Pattern.compile("\"durations\":[[(.*)]]");
    var m = p.matcher(response);
    System.out.println(m);

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
