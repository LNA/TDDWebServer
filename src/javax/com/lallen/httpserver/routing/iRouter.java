package javax.com.lallen.httpserver.routing;
import java.io.IOException;


public interface iRouter {
    public byte[] buildResponseHead(int portNumber) throws IOException;
    public byte[] buildResponseBody() throws IOException;
}
