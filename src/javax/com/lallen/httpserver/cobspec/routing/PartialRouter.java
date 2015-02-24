package javax.com.lallen.httpserver.cobspec.routing;

import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by latoyaallen on 2/23/15.
 */
public class PartialRouter implements iResponse {
    public static final String STATUS = "HTTP/1.1 206 Partial Content\r\n";
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public PartialRouter(iHeader headBuilder, iBody bodyBuilder) {
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
