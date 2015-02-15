package javax.com.lallen.httpserver.mocks;
import java.io.InputStream;

public class MockServerIO {
    private final InputStream openSocket;

    public MockServerIO(InputStream openSocket) {
        this.openSocket = openSocket;
    }

    public String readRequest() {
        return "I read the request";
    }
}
