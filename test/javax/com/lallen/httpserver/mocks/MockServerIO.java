package javax.com.lallen.httpserver.mocks;
import java.io.InputStream;
import java.io.OutputStream;

public class MockServerIO {
    private final InputStream in;
    private final OutputStream out;

    public MockServerIO(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    public String readRequest() {
        return "I read the request";
    }
}
