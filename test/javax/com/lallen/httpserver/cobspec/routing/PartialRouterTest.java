package javax.com.lallen.httpserver.cobspec.routing;
import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.mocks.MockResponseHead;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PartialRouterTest {
    public static final String UTF = "UTF-8";
    public PartialRouter partialRouter;
    public byte[] responseHead;
    public String head;
    public MockResponseHead headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder                = new MockResponseHead();
        Map<String,String> request = new HashMap<>();

        partialRouter              = new PartialRouter(headBuilder, request);
        responseHead               = partialRouter.renderHead(1999);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }
}
