package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.response.HeadBuilder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class GetRouterTest {
    public static final String UTF = "UTF-8";
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    public static final String LOCATION = "Location: http://localhost:1999/" + "\r\n";
    public static final String BLANK_LINE = "\r\n";
    public static final String HEAD_LINES = STATUS + ALLOW + LOCATION + BLANK_LINE;
    public static final String BODY       = "<html><head><title></title></head><body>" + "</body></html>";
    public GetRouter getRouter;
    public byte[] responseHead;
    public String head;
    public HeadBuilder headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new HeadBuilder();
        getRouter = new GetRouter(headBuilder);
        responseHead = getRouter.buildResponseHead(1999);
        head = new String(responseHead, UTF);
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

    @Test
    public void itGivesHTMLBodyTags() throws IOException {
        byte[] responseBody = getRouter.buildResponseBody();
        String body = new String(responseBody, UTF);
        
        assertEquals(BODY, body);
    }
}