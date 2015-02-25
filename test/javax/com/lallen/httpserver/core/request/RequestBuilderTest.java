package javax.com.lallen.httpserver.core.request;
import org.junit.Test;

import javax.com.lallen.httpserver.core.parsers.RequestParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RequestBuilderTest {
    private RequestParser parser;
    private String YAY_INPUT    = "Yay /zombies HTTP/1.1\r\n" + "foo headers" + "Range: bytes=0-8675309";

    private RequestBuilder builder;
    private Map<String,String> request;

    @Test
    public void itBuildsARequest() throws IOException {
        parser = new RequestParser(YAY_INPUT);
        builder = new RequestBuilder(parser, "/folder/empire");
        request = builder.buildRequest();

        assertEquals("Yay/zombies", request.get("RESOURCE"));
        assertEquals("Yay /zombies HTTP/1.1", request.get("STATUS LINE"));
        assertEquals("YAY", request.get("VERB"));
        assertEquals("/zombies", request.get("URI"));
        assertEquals("/folder/empire", request.get("DIRECTORY"));
        assertEquals("/folder/empire/zombies", request.get("PATH"));
        assertEquals("foo headersRange: bytes=0-8675309", request.get("HEADERS"));
        assertEquals("8675309", request.get("RANGE"));
    }

    @Test
    public void itBuildsARequestWithAnEtag() throws IOException {
        parser = new RequestParser("Yay /zombies HTTP/1.1\r\n" + "If-Match: 90210\r\n");
        builder = new RequestBuilder(parser, "/folder/empire");
        request = builder.buildRequest();
        assertEquals("90210", request.get("ETAG"));
    }
}