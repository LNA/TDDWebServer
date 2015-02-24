package javax.com.lallen.httpserver.cobspec.routing;

import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

public class PartialRouter implements iResponse {
    public static final String STATUS = "HTTP/1.1 206 Partial Content\r\n";
    private final iHeader headBuilder;

    public PartialRouter(iHeader headBuilder) {
        this.headBuilder = headBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, STATUS);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        String fileOneString = request.get("PATH");
        Path fileOnePath     = Paths.get(fileOneString);
        byte[] body          = Files.readAllBytes(fileOnePath);
        String requestRange  = request.get("RANGE");
        int range            = Integer.parseInt(requestRange);
        return Arrays.copyOf(body, range);
    }
}
