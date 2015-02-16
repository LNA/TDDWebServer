package javax.com.lallen.httpserver.server;
import org.junit.Test;
import javax.com.lallen.httpserver.mocks.MockConnectionHandler;
import javax.com.lallen.httpserver.mocks.Mocket;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.assertEquals;

public class ConnectionHandlerTest {
    @Test
    public void itHandlesAConnection() throws IOException {
        Mocket mocket = new Mocket(null, null);
        MockConnectionHandler handler = new MockConnectionHandler(null, null, "foo");
    }
}
