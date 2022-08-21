import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

public class Console {

  public static void main(String[] args) throws Exception {
    String oc_token = System.getenv("MAPBOX_TOKEN");
    System.out.println(oc_token);
  }

}
