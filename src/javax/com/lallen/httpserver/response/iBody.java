package javax.com.lallen.httpserver.response;
import java.io.IOException;

public interface iBody {
    public byte[] buildResponseBody() throws IOException;
}
