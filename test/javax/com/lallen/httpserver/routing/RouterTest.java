package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RouterTest {
    private Router router;
    private Map<String,String> request;

    @Before
    public void setUp() throws IOException {
        request = new HashMap<>();
        router  = new Router(request);
    }

    @Test
    public void itSendsARequestToTheRedirectRoute() throws IOException {
        request.put("URI", "REDIRECT");
        assertEquals("REDIRECT", router.sendToRoute());
    }

    @Test
    public void itSendsARequestToAVerbRoute() throws IOException {
        request.put("URI", "Some URI");
        request.put("VERB", "JUMP");
        assertEquals("JUMP", router.sendToRoute());
    }
}
