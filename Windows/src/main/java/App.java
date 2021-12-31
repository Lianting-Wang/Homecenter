import java.net.URI;
import java.net.URISyntaxException;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        String url = "ws://192.168.76.71:3001";
        URI uri = new URI(url);
        Socket ws = new Socket(uri);
        ws.connect();
    }
}