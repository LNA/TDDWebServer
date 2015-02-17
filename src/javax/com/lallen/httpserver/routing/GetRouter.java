package javax.com.lallen.httpserver.routing;
import java.io.IOException;

public class GetRouter implements iRouter {
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    public static final String BLANK_LINE = "\r\n";
    public static final String LOCATION = "Location: http://localhost:";
    public static final String END = "/";


    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        appendLines(stringBuilder, port);
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

    private void appendLines(StringBuilder stringBuilder, int port) {
        stringBuilder.append(STATUS);
        stringBuilder.append(ALLOW);
        stringBuilder.append(LOCATION + port + END + BLANK_LINE);
        stringBuilder.append(BLANK_LINE);
    }
}