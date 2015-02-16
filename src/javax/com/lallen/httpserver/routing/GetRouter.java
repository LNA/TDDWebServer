package javax.com.lallen.httpserver.routing;
import java.io.IOException;

public class GetRouter implements iRouter {
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    public static final String LOCATION = "Location: http://localhost:5000/" + "\r\n";
    public static final String BLANK_LINE = "\r\n";

    public byte[] buildResponseHead() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ALLOW);
        stringBuilder.append(STATUS);
        stringBuilder.append(LOCATION);
        stringBuilder.append(BLANK_LINE);
        String lines = stringBuilder.toString();
        return lines.getBytes();
    }
}