package javax.com.lallen.httpserver.mocks;
import javax.com.lallen.httpserver.core.constants.Response;
import javax.com.lallen.httpserver.core.response.iBody;
import java.io.IOException;

public class MockResponseBody implements iBody {
    @Override
    public byte[] renderBody() throws IOException {
        String constructedBody = "The body has been constructed.";
        return constructedBody.getBytes();
    }
}
