package javax.com.lallen.httpserver.response;
import java.io.IOException;
import java.util.Map;


public interface iResponse {
    public byte[] buildResponseHead(int port) throws IOException;
    public byte[] buildResponseBody(Map<String, String> request) throws IOException;
}