package javax.com.lallen.httpserver.core.response;
import java.io.IOException;

public interface iHeader {
    public byte[] renderHead(int port, String status) throws IOException;
}
