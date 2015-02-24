package javax.com.lallen.httpserver.core.parsers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class RequestParserTest {
    public RequestParser parser;
    public RequestParser parserForHeaders;
    public RequestParser parserForPartial;

    @Before
    public void setUp() throws IOException {
        parser = new RequestParser("BOOK /shouldIGetMoreGames?Yes! HTTP/1.1" + "\r\n" + "foobar");
        parserForHeaders = new RequestParser("foo HTTP/1.1" + "\r\n" + "Authorization: Basic");
        parserForPartial = new RequestParser("foo HTTP/1.1" + "\r\n" + "Range: bytes=0-8675309\r\n");
    }

    @Test
    public void itParsesTheResource() throws IOException {
        assertEquals("BOOK/shouldIGetMoreGames?Yes!", parser.resource());
    }

    @Test
    public void itParsesTheStatusLine() throws IOException {
        assertEquals("BOOK /shouldIGetMoreGames?Yes! HTTP/1.1", parser.statusLine());
    }

    @Test
    public void itParsesTheVerb() throws IOException {
        assertEquals("BOOK", parser.verb());
    }

    @Test
    public void itParsesTheURI() throws IOException {
        assertEquals("/shouldIGetMoreGames?Yes!", parser.uri());
    }

    @Test
    public void itParsesTheHeader() throws IOException {
        assertEquals("Authorization: Basic", parserForHeaders.headers());
    }

    @Test
    public void itParsesTheRangeFromAPartialHeader() throws IOException {
        assertEquals("8675309", parserForPartial.range());
    }
}
