package javax.com.lallen.httpserver.routing;

import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.mocks.MockBodyBuilder;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by latoyaallen on 2/20/15.
 */
public class PatchFileRouterTest {
    public static final String UTF = "UTF-8";
    public PatchFileRouter patchRouter;
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
        patchRouter = new PatchFileRouter(headBuilder, bodyBuilder);
        responseHead = patchRouter.buildResponseHead(1999);
        Map<String,String> request = new HashMap<>();
        responseBody = patchRouter.buildResponseBody(request);
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
