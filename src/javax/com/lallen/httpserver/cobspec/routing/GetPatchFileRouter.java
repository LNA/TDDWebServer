package javax.com.lallen.httpserver.cobspec.routing;

import javax.com.lallen.httpserver.cobspec.constants.ETAG;
import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetPatchFileRouter implements iResponse {
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public GetPatchFileRouter(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;

    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, Status.OK);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        if (!request.get("ETAG").equals(" ")) {
            System.out.println(" Etag is blank line");
            return patchContent();
        } else {
            return defaultContent(request);
        }
    }

    private byte[] patchContent() throws IOException {
        String s = "patched content"; //refactor me!
        byte[] body = s.getBytes();
        return body;
    }

    private byte[] defaultContent(Map<String, String> request) throws IOException {
        String requestPath = request.get("PATH");
        Path fileOnePath     = Paths.get(requestPath);
        byte[] body          = Files.readAllBytes(fileOnePath);
        return body;
    }
}
