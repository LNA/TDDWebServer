package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.cobspec.constants.ETAG;
import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;

public class GetPatchRouter implements iResponse {
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public GetPatchRouter(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;

    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, Status.OK);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        if (request.get("ETAG").equals(ETAG.PATCHED_ETAG)) {
            return patchContent();
        } else {
            return bodyBuilder.buildResponseBody();
        }
    }

    private byte[] patchContent() throws IOException {
        String s = "patched content"; //refactor me!
        byte[] body = s.getBytes();
        return body;
    }
}