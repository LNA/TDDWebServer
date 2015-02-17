package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.mocks.MockBodyBuilder;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iBody;

import java.io.IOException;
import static org.junit.Assert.assertEquals;


/**
 * Created by latoyaallen on 2/17/15.
 */
public class PostRouterTest {
    public static final String UTF = "UTF-8";
    public iRouter postRouter;
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
        responseBody = postRouter.buildResponseBody();
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
