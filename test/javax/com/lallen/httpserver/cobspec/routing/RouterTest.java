package javax.com.lallen.httpserver.cobspec.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.cobspec.routing.Router;
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
        request.put("RESOURCE", "some resource");
        request.put("PATH", "some path");
        request.put("HEADERS", "Some headers");
    }

    @Test
    public void itSendsARequestToTheRedirectRoute() throws IOException {
        request.put("URI", "/redirect");
        assertEquals("REDIRECT", router.sendToRoute());
    }

    @Test
    public void itSendsARequestToAVerbRoute() throws IOException {
        request.put("URI", "Some URI");
        request.put("VERB", "JUMP");
        assertEquals("JUMP", router.sendToRoute());
    }

    @Test
    public void itSendsARequestToAuthRoute() throws IOException {
        request.put("URI", "Some URI");
        request.put("VERB", "JUMP");
        request.put("HEADERS", "Some Authentication headers");
        assertEquals("AUTHENTICATION", router.sendToRoute());
    }

    @Test
    public void itSendsARequestToAuthRouteFromTheBrokenCobSpecRequest() throws IOException {
        request.put("URI", "/logs");
        assertEquals("AUTHENTICATION", router.sendToRoute());
    }

    //Figure out how to mock out Java file and Java path so that I can test any routes that depend on checking for a File.

//    @Test
//    public void itSendsARequestToAGetFileRoute() throws IOException {
//        request.put("URI", "URI.txt");
//        request.put("VERB", "Get");
//        assertEquals("GetFileRouter", router.sendToRoute());
//    }
}
