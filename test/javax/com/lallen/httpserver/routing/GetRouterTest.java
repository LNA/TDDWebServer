package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.mocks.MockBodyBuilder;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class GetRouterTest {
    public static final String UTF = "UTF-8";
    public GetResponse getRouter;
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
        getRouter = new GetResponse(headBuilder, bodyBuilder);
        responseHead = getRouter.buildResponseHead(1999);
        responseBody = getRouter.buildResponseBody();
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