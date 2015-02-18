package javax.com.lallen.httpserver.parsers;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;


public class RequestParserTest {
    public RequestParser parser;

    @Test
    public void itGivesTheCapitalizedRequestType() throws IOException {
        parser = new RequestParser("yay /zombies HTTP/1.1\r\n");
        assertEquals("YAY", parser.requestType());
    }

    @Test
    public void itGivesTheRedirectRequestTypeInsteadOfAVerb() throws IOException {
        parser = new RequestParser("Get /redirect HTTP/1.1\r\n");
        assertEquals("REDIRECT", parser.requestType());
    }

}
