package javax.com.lallen.httpserver.core.response;
import javax.com.lallen.httpserver.core.constants.Response;
import java.io.IOException;

public class ResponseHead implements iHeader {

    @Override
    public byte[] renderHead(int port, String status) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        appendLines(stringBuilder, port, status);
        String lines = stringBuilder.toString();
        return lines.getBytes();
    }

    private void appendLines(StringBuilder stringBuilder, int port, String status) {
        stringBuilder.append(status);
        stringBuilder.append(Response.ALLOW);
        stringBuilder.append(Response.LOCATION + port + Response.END + Response.NEW_LINE);
        stringBuilder.append(Response.NEW_LINE);
    }
}
