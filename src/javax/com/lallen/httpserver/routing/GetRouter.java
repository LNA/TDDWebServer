package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.HeadBuilder;
import java.io.IOException;

public class GetRouter implements iRouter {
    private final HeadBuilder headBuilder;

    public GetRouter(HeadBuilder headBuilder) {
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