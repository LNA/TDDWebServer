package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iResponse;
import java.io.IOException;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFileRouter implements iResponse {
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    private final iHeader headBuilder;

    public GetFileRouter(iHeader headBuilder) {
        this.headBuilder = headBuilder;
    }
    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, STATUS);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        String file = request.get("DIRECTORY") + request.get("URI");
        Path filePath = Paths.get(file);
        byte[] body   = Files.readAllBytes(filePath);
        return body;
    }
}