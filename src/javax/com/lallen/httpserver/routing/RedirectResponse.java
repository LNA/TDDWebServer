package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iBody;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iResponse;
import java.io.IOException;

public class RedirectResponse implements iResponse {
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public RedirectResponse(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port);
    }

    @Override
    public byte[] buildResponseBody() throws IOException {
        return bodyBuilder.buildResponseBody();
    }
}
