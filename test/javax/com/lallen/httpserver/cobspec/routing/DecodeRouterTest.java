package javax.com.lallen.httpserver.cobspec.routing;

import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.core.response.iResponse;
import javax.com.lallen.httpserver.mocks.MockResponseHead;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DecodeRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse decodeRouter;
    public byte[] responseHead;
    public String head;
    public MockResponseHead headBuilder;
    public Map<String, String> request;

    @Before
    public void setUp() throws IOException {
        headBuilder  = new MockResponseHead();
        decodeRouter = new DecodeRouter(headBuilder, request);
        responseHead = decodeRouter.renderHead(227);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }
}
