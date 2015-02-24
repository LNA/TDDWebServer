package javax.com.lallen.httpserver.core.routing;
import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.mocks.MockBodyBuilder;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PostRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse postRouter;
    public byte[] responseHead;
    public byte[] responseBody;
    public String head;
    public String body;
    public iHeader headBuilder;
    public iBody bodyBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new MockHeadBuilder();
        bodyBuilder = new MockBodyBuilder();
        postRouter = new OptionsRouter(headBuilder, bodyBuilder);
        responseHead = postRouter.buildResponseHead(90210);
        Map<String,String> request = new HashMap<>();
        responseBody = postRouter.buildResponseBody(request);
        head = new String(responseHead, UTF);
        body = new String(responseBody, UTF);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        assertEquals("The head has been constructed.", head);
    }

    @Test
    public void itGivesBehaviorOfTheBodyBuilder() throws IOException {
        assertEquals("The body has been constructed.", body);
    }
}
