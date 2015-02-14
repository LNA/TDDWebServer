package javax.com.lallen.httpserver;

import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.server.Server;

import javax.com.lallen.httpserver.mocks.Mocket;
import javax.com.lallen.httpserver.mocks.MocketWrapper;
import javax.com.lallen.httpserver.sockets.iServerSocket;

import static org.junit.Assert.assertEquals;
import java.io.IOException;

/**
 * Created by latoyaallen on 2/10/15.
 */
public class ServerTest {
    private Server server;
    private iServerSocket serverSocket;

    @Before
    public void setUp() throws IOException {
        serverSocket = new MocketWrapper(new Mocket(null, null));
        server = new Server(serverSocket, "foo");
        server.start();
}

    @Test
    public void itStartsAConnection() throws Exception {
        assertEquals(true, server.isBound());
    }

    @Test
    public void itClosesAConnection() throws IOException {
        assertEquals(true, server.isClosed());
    }
}
