package javax.com.lallen.httpserver.mocks;

import javax.com.lallen.httpserver.routing.Router;
import javax.com.lallen.httpserver.server.ServerIO;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by latoyaallen on 2/14/15.
 */
public class MockConnectionHandler {
    private final InputStream openSocket;
    private final String directory;
    public final MockServerIO io;

    public MockConnectionHandler(InputStream openSocket, String directory) throws IOException {
        this.openSocket = openSocket;
        this.directory = directory;
        this.io = new MockServerIO(openSocket);
    }

    public String run() {
        String readRequestLines = io.readRequest();
        return readRequestLines;
    }
}