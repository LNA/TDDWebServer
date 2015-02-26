package javax.com.lallen.httpserver.core.routing;
import org.junit.Before;
import org.junit.Test;

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

    }

    @Test
    public void itAdds404StatusToHeadWhenNoFilesFound() throws IOException {
        Map<String,String> request = new HashMap<>();
        request.put("PATH", "/wat");
        getRouter = new GetRouter(headBuilder, request);
        getRouter.buildResponseHead(999);
        assertEquals(headBuilder.getSTATUS(), "HTTP/1.1 404 NOT FOUND\r\n");
    }

//    @Test
//    public void itGivesABodyWithFileLinks() throws IOException {
//        body = new String(responseBody, UTF);
//        assertEquals("The body has been constructed.", body);
//    }
}