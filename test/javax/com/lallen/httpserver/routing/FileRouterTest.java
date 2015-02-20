package javax.com.lallen.httpserver.routing;

import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import javax.com.lallen.httpserver.response.iResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by latoyaallen on 2/19/15.
 */
public class FileRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse fileRouter;
    public byte[] responseHead;
    public String head;
    public MockHeadBuilder headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new MockHeadBuilder();
        fileRouter = new GetFileRouter(headBuilder);
        responseHead = fileRouter.buildResponseHead(227);
        Map<String,String> request = new HashMap<>();
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }
}
