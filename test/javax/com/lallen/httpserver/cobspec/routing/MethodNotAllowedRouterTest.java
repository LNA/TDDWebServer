package javax.com.lallen.httpserver.cobspec.routing;

import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.cobspec.routing.MethodNotAllowedRouter;
import javax.com.lallen.httpserver.mocks.MockBodyBuilder;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MethodNotAllowedRouterTest {
    public static final String UTF = "UTF-8";
    public MethodNotAllowedRouter methodNotAllowedRouter;
    public byte[] responseHead;
    public byte[] responseBody;
    public String head;
    public String body;
    public MockHeadBuilder headBuilder;
    public MockBodyBuilder bodyBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new MockHeadBuilder();
        bodyBuilder = new MockBodyBuilder();
        methodNotAllowedRouter = new MethodNotAllowedRouter(headBuilder, bodyBuilder);
        responseHead = methodNotAllowedRouter.buildResponseHead(1999);
        Map<String,String> request = new HashMap<>();
        responseBody = methodNotAllowedRouter.buildResponseBody(request);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }

    @Test
    public void itGivesABlankBody() throws IOException {
        body = new String(responseBody, UTF);
        assertEquals("The body has been constructed.", body);
    }
}
