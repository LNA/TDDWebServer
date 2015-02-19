package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.mocks.MockBodyBuilder;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iBody;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class OptionsRouterTest {
    public static final String UTF = "UTF-8";
    public OptionsResponse optionsRouter;
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
        optionsRouter = new OptionsResponse(headBuilder, bodyBuilder);
        responseHead = optionsRouter.buildResponseHead(4040);
        Map<String,String> request = new HashMap<>();
        responseBody = optionsRouter.buildResponseBody(request);
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
