package javax.com.lallen.httpserver.core.response;
import java.io.IOException;
import java.util.Map;

public interface iResponse {
    public byte[] buildResponseHead(int port) throws IOException;
    public byte[] buildResponseBody() throws IOException;
}