package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;


public class AuthenticationRouter implements iResponse {
    private final iHeader responseHead;

    public AuthenticationRouter(iHeader responseHead) {
        this.responseHead = responseHead;
    }

    @Override
    public byte[] renderHead(int port) throws IOException {
        return responseHead.renderHead(port, Status.UNAUTHORIZED);
    }

    @Override
    public byte[] renderBody() throws IOException {
        String body = "Authentication required";
        return body.getBytes();
    }
}