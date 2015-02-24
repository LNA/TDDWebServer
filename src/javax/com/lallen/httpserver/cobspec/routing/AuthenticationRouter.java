package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;


public class AuthenticationRouter implements iResponse {
    public static final String STATUS = "HTTP/1.1 401 Unauthorized\r\n";
    private final iHeader headBuilder;

    public AuthenticationRouter(iHeader headBuilder) {
        this.headBuilder = headBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, STATUS);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        String body = "Authentication required";
        return body.getBytes();
    }
}