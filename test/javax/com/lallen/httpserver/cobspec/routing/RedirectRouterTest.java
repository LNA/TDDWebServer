package javax.com.lallen.httpserver.cobspec.routing;
import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.mocks.MockResponseBody;
import javax.com.lallen.httpserver.mocks.MockResponseHead;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import javax.com.lallen.httpserver.core.routing.OptionsRouter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RedirectRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse redirectRouter;
    public byte[] responseHead;
    public byte[] responseBody;
    public String head;
    public String body;
    public iHeader headBuilder;
    public iBody bodyBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new MockResponseHead();
        bodyBuilder = new MockResponseBody();
        redirectRouter = new OptionsRouter(headBuilder, bodyBuilder);
        responseHead = redirectRouter.renderHead(90210);
        Map<String,String> request = new HashMap<>();
        responseBody = redirectRouter.renderBody();
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
