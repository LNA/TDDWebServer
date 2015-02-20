package javax.com.lallen.httpserver.parsers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class RequestParserTest {
    public RequestParser parser;

    @Before
    public void setUp() throws IOException {
        parser = new RequestParser("BOOK /shouldIGetMoreGames?Yes! HTTP/1.1" + "\r\n" + "foobar");
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
}
