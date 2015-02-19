package javax.com.lallen.httpserver.response;
import java.io.IOException;


public interface iResponse {
    public byte[] buildResponseHead(int port) throws IOException;
    public byte[] buildResponseBody() throws IOException;
}