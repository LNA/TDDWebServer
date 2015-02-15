package javax.com.lallen.httpserver.server;
import java.io.IOException;
import java.io.InputStream;
import javax.com.lallen.httpserver.routing.Router;

/**
 * Created by latoyaallen on 2/14/15.
 */
public class ConnectionHandler {
    private final InputStream openSocket;
    private final ServerIO io;
    private final Router router;
    private final String directory;

    public ConnectionHandler(InputStream openSocket, String directory) throws IOException {
        this.openSocket = openSocket;
        this.directory = directory;
        this.io = new ServerIO(openSocket);
        this.router = new Router();
    }

    public String run() throws IOException {
        String requestLines = io.readRequest();
        return requestLines;
    }
}
