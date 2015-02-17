package javax.com.lallen.httpserver.mocks;
import javax.com.lallen.httpserver.response.iBody;
import java.io.IOException;

public class MockBodyBuilder implements iBody {

    @Override
    public byte[] buildResponseBody() throws IOException {
        String headBuilt = "The body has been constructed.";
        return headBuilt.getBytes();
    }
}
