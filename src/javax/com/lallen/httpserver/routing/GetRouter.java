package javax.com.lallen.httpserver.routing;
import java.io.IOException;

public class GetRouter implements iRouter {
    public byte[] buildResponseHead() throws IOException {
        String allow = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
        return allow.getBytes();
    }
}