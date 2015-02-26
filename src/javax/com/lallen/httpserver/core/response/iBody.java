package javax.com.lallen.httpserver.core.response;
import java.io.IOException;

public interface iBody {
    public byte[] renderBody() throws IOException;
}
