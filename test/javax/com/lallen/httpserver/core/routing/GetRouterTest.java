package javax.com.lallen.httpserver.core.routing;
import org.junit.Before;

import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetRouterTest {
    public static final String UTF = "UTF-8";
    public GetRouter getRouter;
    public byte[] responseHead;
    public byte[] responseBody;
    public String head;
    public String body;
    public MockHeadBuilder headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new MockHeadBuilder();
        getRouter = new GetRouter(headBuilder);
        responseHead = getRouter.buildResponseHead(1999);
        Map<String,String> request = new HashMap<>();
        responseBody = getRouter.buildResponseBody(request);
    }
//
//    @Test
//    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
//        head = new String(responseHead, UTF);
//        assertEquals("The head has been constructed.", head);
//    }
//
//    @Test
//    public void itGivesABodyWithFileLinks() throws IOException {
//        body = new String(responseBody, UTF);
//        assertEquals("The body has been constructed.", body);
//    }
}