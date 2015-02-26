package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;

public class GetLogsRouter implements iResponse {
    public static final String GET_LOG                 = "GET /log HTTP/1.1";
    public static final String PUT_THESE               = "PUT /these HTTP/1.1";
    public static final String HEAD_REQUESTS           = "HEAD /requests HTTP/1.1";
    public static final String AUTHENTICATION_REQUIRED = "Authentication required";
    private final iHeader responseHead;

    public GetLogsRouter(iHeader responseHead) {
        this.responseHead = responseHead;
    }

    @Override
    public byte[] renderHead(int port) throws IOException {
        return responseHead.renderHead(port, Status.OK);
    }

    @Override
    public byte[] renderBody() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        appendLines(stringBuilder);
        String lines = stringBuilder.toString();
        return lines.getBytes();
    }

    private void appendLines(StringBuilder stringBuilder) {
        stringBuilder.append(AUTHENTICATION_REQUIRED);
        stringBuilder.append(GET_LOG);
        stringBuilder.append(PUT_THESE);
        stringBuilder.append(HEAD_REQUESTS);
    }
}