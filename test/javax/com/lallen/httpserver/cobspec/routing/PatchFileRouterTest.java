package javax.com.lallen.httpserver.cobspec.routing;

import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.mocks.MockResponseBody;
import javax.com.lallen.httpserver.mocks.MockResponseHead;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PatchFileRouterTest {
    public static final String UTF = "UTF-8";
    public PatchFileRouter patchRouter;
    public byte[] responseHead;
    public byte[] responseBody;
    public String head;
    public String body;
    public MockResponseHead headBuilder;
    public MockResponseBody bodyBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new MockResponseHead();
        bodyBuilder = new MockResponseBody();
        patchRouter = new PatchFileRouter(headBuilder, bodyBuilder);
        responseHead = patchRouter.renderHead(1999);
        Map<String,String> request = new HashMap<>();
        responseBody = patchRouter.renderBody();
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
