package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iBody;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iResponse;
import java.io.IOException;
import java.util.Map;

public class MethodNotAllowedRouter implements iResponse {
    public static final String STATUS = "HTTP/1.1 405 Method Not Allowed\r\n";

    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public MethodNotAllowedRouter(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, STATUS);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        return bodyBuilder.buildResponseBody();
    }
}
