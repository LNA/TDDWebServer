package javax.com.lallen.httpserver.routing;

import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.mocks.MockBodyBuilder;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import javax.com.lallen.httpserver.response.iResponse;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by latoyaallen on 2/19/15.
 */
public class FileRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse fileRouter;
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
        fileRouter = new FileResponse(headBuilder, bodyBuilder);
        responseHead = fileRouter.buildResponseHead(227);
        responseBody = fileRouter.buildResponseBody();
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
