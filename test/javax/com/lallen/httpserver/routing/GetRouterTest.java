package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class GetRouterTest {
    public static final String UTF = "UTF-8";
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    public static final String LOCATION = "Location: http://localhost:5000/" + "\r\n";
    public static final String BLANK_LINE = "\r\n";
    public static final String HEAD_LINES = ALLOW + STATUS + LOCATION + BLANK_LINE;
    public GetRouter getRouter;
    public byte[] response;
    public String head;

    @Before
    public void setUp() throws IOException {
        getRouter = new GetRouter();
        response = getRouter.buildResponseHead();
        head = new String(response, UTF);
    }

    @Test
    public void itGivesAllowForTheHeader() throws IOException {
        assertEquals(true, head.contains(ALLOW));
    }

    @Test
    public void itGivesTheStatusLine() throws IOException {
        assertEquals(true, head.contains(STATUS));
    }

    @Test
    public void itGivesTheLocation() throws IOException {
        assertEquals(true, head.contains(LOCATION));
    }

    @Test
    public void itGivesTheHeaderInTheCorrectOrder() throws IOException {
        assertEquals(HEAD_LINES, head);
    }
}