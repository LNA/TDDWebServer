package javax.com.lallen.httpserver.cobspec.routing;

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
    private final iHeader responseHead;
    private final Map<String,String> request;

    public GetPatchFileRouter(iHeader responseHead, Map<String, String> request) {
        this.responseHead = responseHead;
        this.request = request;
    }

    @Override
    public byte[] renderHead(int port) throws IOException {
        return responseHead.renderHead(port, Status.OK);
    }

    @Override
    public byte[] renderBody() throws IOException {
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
        String requestPath   = request.get("PATH");
        Path fileOnePath     = Paths.get(requestPath);
        byte[] body          = Files.readAllBytes(fileOnePath);
        return body;
    }
}