package javax.com.lallen.httpserver.cobspec.routing;

import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.mocks.MockResponseHead;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetFileRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse fileRouter;
    public byte[] responseHead;
    public String head;
    public MockResponseHead headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder  = new MockResponseHead();
        Map<String,String> request = new HashMap<>();
        fileRouter   = new GetFileRouter(headBuilder, request);
        responseHead = fileRouter.renderHead(227);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }
}
