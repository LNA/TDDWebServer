package javax.com.lallen.httpserver.cobspec.routing;
import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PartialRouterTest {
    public static final String UTF = "UTF-8";
    public PartialRouter partialRouter;
    public byte[] responseHead;
    public String head;
    public MockHeadBuilder headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder                = new MockHeadBuilder();
        partialRouter              = new PartialRouter(headBuilder);
        responseHead               = partialRouter.buildResponseHead(1999);
        Map<String,String> request = new HashMap<>();
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        head = new String(responseHead, UTF);
        assertEquals("The head has been constructed.", head);
    }
}
