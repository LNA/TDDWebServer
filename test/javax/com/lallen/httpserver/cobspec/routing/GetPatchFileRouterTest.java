package javax.com.lallen.httpserver.cobspec.routing;
import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.core.response.iResponse;
import javax.com.lallen.httpserver.mocks.MockResponseBody;
import javax.com.lallen.httpserver.mocks.MockResponseHead;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetPatchFileRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse getPatchFileRouter;
    public byte[] responseHead;
    public String head;
    public MockResponseHead headBuilder;
    public MockResponseBody bodyBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder    = new MockResponseHead();
        bodyBuilder    = new MockResponseBody();
        Map<String,String> request = new HashMap<>();

        getPatchFileRouter = new GetPatchFileRouter(headBuilder,request);
        responseHead   = getPatchFileRouter.renderHead(227);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }
}
