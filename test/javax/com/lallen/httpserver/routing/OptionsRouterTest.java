package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.response.HeadBuilder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class OptionsRouterTest {
    public static final String UTF = "UTF-8";
    public static final String ALLOW = "Allow: GET,HEAD,POST,OPTIONS,PUT\r\n";
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    public static final String LOCATION = "Location: http://localhost:4040/" + "\r\n";
    public static final String BLANK_LINE = "\r\n";
    public static final String HEAD_LINES = STATUS + ALLOW + LOCATION + BLANK_LINE;
    public static final String BODY       = "<html><head><title></title></head><body>" + "</body></html>";
    public OptionsRouter optionsRouter;
    public byte[] responseHead;
    public String head;
    public HeadBuilder headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new HeadBuilder();
        optionsRouter = new OptionsRouter(headBuilder);
        responseHead = optionsRouter.buildResponseHead(4040);
        head = new String(responseHead, UTF);
    }

    @Test
    public void itGivesTheHeaderInTheCorrectOrder() throws IOException {
        assertEquals(HEAD_LINES, head);
    }

    @Test
    public void itGivesHTMLBodyTags() throws IOException {
        byte[] responseBody = optionsRouter.buildResponseBody();
        String body = new String(responseBody, UTF);

        assertEquals(BODY, body);
    }
}
