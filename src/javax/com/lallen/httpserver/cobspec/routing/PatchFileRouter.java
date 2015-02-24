package javax.com.lallen.httpserver.cobspec.routing;

import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;

public class PatchFileRouter implements iResponse {
    private final iHeader headBuilder;
    private final iBody   bodyBuilder;


    public PatchFileRouter(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, "200 OK");
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        return bodyBuilder.buildResponseBody();
    }
}
