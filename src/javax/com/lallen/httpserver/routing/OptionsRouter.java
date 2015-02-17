package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iBody;
import javax.com.lallen.httpserver.response.iHeader;
import java.io.IOException;

/**
 * Created by latoyaallen on 2/17/15.
 */
public class OptionsRouter implements iRouter {
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public OptionsRouter(iHeader headBuilder, iBody bodyBuilder) {
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
