package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetFileRouter implements iResponse {
    private final iHeader responseHead;
    private final Map<String, String> request;

    public GetFileRouter(iHeader responseHead, Map<String, String> request) {
        this.responseHead = responseHead;
        this.request = request;
    }
    @Override
    public byte[] renderHead(int port) throws IOException {
        return responseHead.renderHead(port, Status.OK);
    }

    @Override
    public byte[] renderBody() throws IOException {
        String file = request.get("DIRECTORY") + request.get("URI");
        Path filePath = Paths.get(file);
        byte[] body   = Files.readAllBytes(filePath);
        return body;
    }
}