package javax.com.lallen.httpserver.response;
import java.io.IOException;

public class HeadBuilder implements iHeader {
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

    private void appendLines(StringBuilder stringBuilder, int port) {
        stringBuilder.append(STATUS);
        stringBuilder.append(ALLOW);
        stringBuilder.append(LOCATION + port + END + BLANK_LINE);
        stringBuilder.append(BLANK_LINE);
    }
}
