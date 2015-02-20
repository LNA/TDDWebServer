package javax.com.lallen.httpserver.response;
import java.io.IOException;

public class HeadBuilder implements iHeader {
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String NEW_LINE = "\r\n";
    public static final String LOCATION = "Location: http://localhost:";
    public static final String END = "/";

    @Override
    public byte[] buildResponseHead(int port, String status) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        appendLines(stringBuilder, port, status);
        String lines = stringBuilder.toString();
        System.out.println("head lines" + lines);
        return lines.getBytes();
    }

    private void appendLines(StringBuilder stringBuilder, int port, String status) {
        stringBuilder.append(status);
        stringBuilder.append(ALLOW);
        stringBuilder.append(LOCATION + port + END + NEW_LINE);
        stringBuilder.append(NEW_LINE);
    }
}
