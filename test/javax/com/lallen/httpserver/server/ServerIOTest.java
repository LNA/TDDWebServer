package javax.com.lallen.httpserver.server;

import org.junit.Test;

import javax.com.lallen.httpserver.mocks.Mocket;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import static org.junit.Assert.assertEquals;

/**
 * Created by latoyaallen on 2/13/15.
 */
public class ServerIOTest {
    @Test

    public void itReadsARequest() throws IOException {
        String input = "Keep Pushing On";
        byte[] mockInput = input.getBytes();
        Mocket mocket = new Mocket(new ByteArrayInputStream(mockInput), null);

        InputStream openSocket = mocket.getInputStream();
        ServerIO serverIO = new ServerIO(openSocket);

        assertEquals("Keep Pushing On", serverIO.readRequest());
    }
}
