package javax.com.lallen.httpserver.routing;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class GetRouterTest {
    public static final String UTF = "UTF-8";

    @Test
    public void itGivesAllowForTheHeader() throws IOException {
        GetRouter getRouter = new GetRouter();
        byte[] response = getRouter.buildResponseHead();
        String head = new String(response, UTF);

        assertEquals(true, head.contains("Allow: GET,HEAD,POST,OPTIONS,PUT\r\n"));
    }
}