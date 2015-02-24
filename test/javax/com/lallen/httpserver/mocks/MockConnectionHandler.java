package javax.com.lallen.httpserver.mocks;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by latoyaallen on 2/14/15.
 */
public class MockConnectionHandler {
    private final String directory;
    public final MockServerIO io;

    public MockConnectionHandler(InputStream in, OutputStream out, String directory) throws IOException {
        this.directory = directory;
        this.io = new MockServerIO(in, out);
    }

    public void run() throws IOException {

    }
}