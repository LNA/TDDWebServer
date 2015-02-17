package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;
import javax.com.lallen.httpserver.mocks.MockHeadBuilder;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class OptionsRouterTest {
    public static final String UTF = "UTF-8";
    public static final String BODY       = "<html><head><title></title></head><body>" + "</body></html>";
    public OptionsRouter optionsRouter;
    public byte[] responseHead;
    public String head;
    public MockHeadBuilder headBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new MockHeadBuilder();
        optionsRouter = new OptionsRouter(headBuilder);
        responseHead = optionsRouter.buildResponseHead(4040);
        head = new String(responseHead, UTF);
    }

    @Test
    public void itGivesBehaviorOfTheHeadBuilder() throws IOException {
        assertEquals("The head has been constructed.", head);
    }

    @Test
    public void itGivesHTMLBodyTags() throws IOException {
        byte[] responseBody = optionsRouter.buildResponseBody();
        String body = new String(responseBody, UTF);

        assertEquals(BODY, body);
    }
}
