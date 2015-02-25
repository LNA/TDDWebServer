package javax.com.lallen.httpserver.cobspec.routing;

import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.core.response.iResponse;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class DecodeRouterTest {
    public static final String UTF = "UTF-8";
    public iResponse decodeRouter;
    public byte[] responseHead;
    public String head;
    public MockHeadBuilder headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder  = new MockHeadBuilder();
        decodeRouter = new DecodeRouter(headBuilder);
        responseHead = decodeRouter.buildResponseHead(227);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }
}