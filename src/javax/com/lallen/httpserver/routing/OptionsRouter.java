package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iHeader;
import java.io.IOException;

/**
 * Created by latoyaallen on 2/17/15.
 */
public class OptionsRouter implements iRouter {
    private final iHeader headBuilder;

    public OptionsRouter(iHeader headBuilder) {
        this.headBuilder = headBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port);
    }

    @Override
    public byte[] buildResponseBody() throws IOException {
        String body;
        body = "<html><head><title></title></head><body>";
        body += "</body></html>";
        return body.getBytes();
    }
}
