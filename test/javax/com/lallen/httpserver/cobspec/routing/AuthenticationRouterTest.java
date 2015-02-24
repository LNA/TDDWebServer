package javax.com.lallen.httpserver.cobspec.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AuthenticationRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse authRouter;
    public byte[] responseHead;
    public byte[] responseBody;
    public String head;
    public String body;
    public MockHeadBuilder headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new MockHeadBuilder();
        Map<String,String> request = new HashMap<>();
        authRouter = new AuthenticationRouter(headBuilder);
        responseHead = authRouter.buildResponseHead(227);
        responseBody = authRouter.buildResponseBody(request);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }

    @Test
    public void itGivesTheAuthorizationRequiredBody() throws IOException {
        body = new String(responseBody, UTF);
        assertEquals("Authentication required", body);
    }
}