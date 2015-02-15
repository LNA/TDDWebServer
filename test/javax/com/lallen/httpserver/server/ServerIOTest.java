package javax.com.lallen.httpserver.server;

import org.junit.Test;

import javax.com.lallen.httpserver.mocks.Mocket;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

/**
 * Created by latoyaallen on 2/13/15.
 */
public class ServerIOTest {
    public static final String FULL_INPUT = "Keep Pushing On";
    public static final String EMPTY_INPUT = " ";

    @Test
    public void itReadsARequest() throws IOException {
        Mocket mocket = new Mocket(new ByteArrayInputStream(FULL_INPUT.getBytes()), null);
        InputStream openSocket = mocket.getInputStream();
        ServerIO serverIO = new ServerIO(openSocket);

        assertEquals("Keep Pushing On", serverIO.readRequest());
    }

    @Test
    public void itGivesABlankStringForAnEmptyRequest() throws IOException {
        Mocket mocket = new Mocket(new ByteArrayInputStream(EMPTY_INPUT.getBytes()), null);
        InputStream openSocket = mocket.getInputStream();
        ServerIO serverIO = new ServerIO(openSocket);

        assertEquals(" ", serverIO.readRequest());
    }
}
