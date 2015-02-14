package javax.com.lallen.httpserver.server;
import org.junit.Test;
import javax.com.lallen.httpserver.mocks.MockConnectionHandler;
import javax.com.lallen.httpserver.mocks.Mocket;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class ConnectionHandlerTest {

    @Test
    public void itDoesSomething() throws IOException {
        String input = "some input";
        Mocket mocket = new Mocket(new ByteArrayInputStream(input.getBytes()), null);
        InputStream openSocket = mocket.getInputStream();
        MockConnectionHandler handler = new MockConnectionHandler(openSocket, "foo" );
        assertEquals("I read the request", handler.run());
    }
}
