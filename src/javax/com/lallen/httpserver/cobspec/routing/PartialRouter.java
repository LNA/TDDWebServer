package javax.com.lallen.httpserver.cobspec.routing;

import javax.com.lallen.httpserver.core.constants.Status;
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
    private final iHeader headBuilder;
    private final Map<String,String> request;

    public PartialRouter(iHeader headBuilder, Map<String, String> request) {
        this.headBuilder = headBuilder;
        this.request = request;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, Status.PARTIAL_CONTENT);
    }

    @Override
    public byte[] buildResponseBody() throws IOException {
        String fileOneString = request.get("PATH");
        Path fileOnePath     = Paths.get(fileOneString);
        byte[] body          = Files.readAllBytes(fileOnePath);
        String requestRange  = request.get("RANGE");
        int range            = Integer.parseInt(requestRange);
        return Arrays.copyOf(body, range);
    }
}