package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;

public class RedirectRouter implements iResponse {
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public RedirectRouter(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, Status.FOUND);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        return bodyBuilder.buildResponseBody();
    }
}