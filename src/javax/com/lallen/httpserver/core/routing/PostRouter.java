package javax.com.lallen.httpserver.core.routing;

import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;

public class PostRouter implements iResponse {
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public PostRouter(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
    }

    @Override
    public byte[] renderHead(int port) throws IOException {
        return headBuilder.renderHead(port, Status.OK);
    }

    @Override
    public byte[] renderBody() throws IOException {
        return bodyBuilder.renderBody();
    }
}
