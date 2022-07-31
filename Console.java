import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

public class Console {

  public static void main(String[] args) throws Exception {
    String[]  hospitalsPositions = {"47.2108967,-1.5533024", "47.2001896,-1.4284585"};
    String[] names = {"John", "Jade", "Love", "Allen"};
    System.out.println("coucou");
    String position = hospitalsPositions[0];
    System.out.println(position);
  }

}
