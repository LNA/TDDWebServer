package javax.com.lallen.httpserver.server;

import org.junit.Test;

import javax.com.lallen.httpserver.mocks.Mocket;
import java.io.*;

import static org.junit.Assert.assertEquals;

public class ServerIOTest {
    public static final String FULL_INPUT = "Keep Pushing On";
    public static final String EMPTY_INPUT = " ";

    @Test
    public void itReadsARequest() throws IOException {
        Mocket mocket = new Mocket(new ByteArrayInputStream(FULL_INPUT.getBytes()), null);
        InputStream in = mocket.getInputStream();
        OutputStream out = mocket.getOutputStream();
        ServerIO serverIO = new ServerIO(in, out);

        assertEquals("Keep Pushing On", serverIO.readRequest());
    }

    @Test
    public void itGivesABlankStringForAnEmptyRequest() throws IOException {
        Mocket mocket = new Mocket(new ByteArrayInputStream(EMPTY_INPUT.getBytes()), null);
        InputStream in = mocket.getInputStream();
        OutputStream out = mocket.getOutputStream();
        ServerIO serverIO = new ServerIO(in, out);

        assertEquals(" ", serverIO.readRequest());
    }

    @Test
    public void itWritesAResponse() throws IOException {
        Mocket mocket = new Mocket(new ByteArrayInputStream(EMPTY_INPUT.getBytes()), new ByteArrayOutputStream());
        InputStream in = mocket.getInputStream();
        OutputStream out = mocket.getOutputStream();
        ServerIO serverIO = new ServerIO(in, out);
        String head = "It won't take long ";
        String body = "keep-on pushin to the top";
        serverIO.writeResponse(head.getBytes(), body.getBytes());


        assertEquals("It won't take long keep-on pushin to the top", out.toString());
    }
}
