package javax.com.lallen.httpserver.request;
import org.junit.Test;

import javax.com.lallen.httpserver.parsers.RequestParser;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RequestBuilderTest {
    private RequestParser parser;
    private String YAY_INPUT    = "Yay /zombies HTTP/1.1\r\n";
    private RequestBuilder builder;
    private Map<String,String> request;

    @Test
    public void itBuildsARequest() throws IOException {
        parser = new RequestParser(YAY_INPUT);
        builder = new RequestBuilder(parser, "empire");
        request = builder.buildRequest();

        assertEquals("Yay /zombies HTTP/1.1", request.get("STATUS LINE"));
        assertEquals("YAY", request.get("VERB"));
        assertEquals("/zombies", request.get("URI"));
        assertEquals("empire", request.get("DIRECTORY"));
    }
}