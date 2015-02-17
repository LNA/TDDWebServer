package javax.com.lallen.httpserver.routing;
import java.io.IOException;


public interface iRouter {
    public byte[] buildResponseHead(int port) throws IOException;
    public byte[] buildResponseBody() throws IOException;
}