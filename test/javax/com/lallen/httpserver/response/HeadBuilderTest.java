package javax.com.lallen.httpserver.response;

import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.routing.OptionsRouter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by latoyaallen on 2/17/15.
 */
public class HeadBuilderTest {
    public static final String UTF = "UTF-8";
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    public static final String LOCATION = "Location: http://localhost:4040/" + "\r\n";
    public static final String BLANK_LINE = "\r\n";
    public static final String HEAD_LINES = STATUS + ALLOW + LOCATION + BLANK_LINE;
    public HeadBuilder headBuilder;
    public byte[] responseHead;
    public String head;

    @Before
    public void setUp() throws IOException {
        headBuilder = new HeadBuilder();
        responseHead = headBuilder.buildResponseHead(4040);
        head = new String(responseHead, UTF);
    }

    @Test
    public void itGivesTheHeaderInTheCorrectOrder() throws IOException {
        assertEquals(HEAD_LINES, head);
    }
}
