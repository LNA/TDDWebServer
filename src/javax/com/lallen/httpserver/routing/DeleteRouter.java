package javax.com.lallen.httpserver.routing;

import javax.com.lallen.httpserver.response.iBody;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iResponse;
import java.io.IOException;
import java.util.Map;

public class DeleteRouter implements iResponse{
    public static final String NEW_LINE = "\r\n";
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public DeleteRouter(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, "200 OK");
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        String body = NEW_LINE;
        return body.getBytes();
    }
}
