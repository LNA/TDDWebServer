package javax.com.lallen.httpserver.request;
import org.junit.Test;

import javax.com.lallen.httpserver.parsers.RequestParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RequestBuilderTest {
    private RequestParser parser;
    private String YAY_INPUT    = "Yay /zombies HTTP/1.1\r\n";

    @Test
    public void itBuildsARequest() throws IOException {
        parser = new RequestParser(YAY_INPUT);
        RequestBuilder builder = new RequestBuilder(parser);
        Map<String,String> request = builder.buildRequest();

        assertEquals("YAY", request.get("Type"));
    }
}
