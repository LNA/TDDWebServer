package javax.com.lallen.httpserver.cobspec.routing;

import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;

public class PatchFileRouter implements iResponse {
    private final iHeader responseHead;
    private final iBody responseBody;


    public PatchFileRouter(iHeader responseHead, iBody responseBody) {
        this.responseHead = responseHead;
        this.responseBody = responseBody;
    }

    @Override
    public byte[] renderHead(int port) throws IOException {
        return responseHead.renderHead(port, Status.NO_CONTENT);
    }

    @Override
    public byte[] renderBody() throws IOException {
        return responseBody.renderBody();
    }
}
