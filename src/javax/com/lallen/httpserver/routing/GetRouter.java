package javax.com.lallen.httpserver.routing;
import java.io.IOException;

public class GetRouter implements iRouter {
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    public static final String LOCATION = "Location: http://localhost:5000/" + "\r\n";
    public static final String BLANK_LINE = "\r\n";

    @Override
    public byte[] buildResponseHead() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        appendLines(stringBuilder);
        String lines = stringBuilder.toString();
        return lines.getBytes();
    }

    @Override
    public byte[] buildResponseBody() throws IOException {
        String body;
        body = "<html><head><title></title></head><body>";
        body += "</body></html>";
        return body.getBytes();
    }

    private void appendLines(StringBuilder stringBuilder) {
        stringBuilder.append(ALLOW);
        stringBuilder.append(STATUS);
        stringBuilder.append(LOCATION);
        stringBuilder.append(BLANK_LINE);
    }
}