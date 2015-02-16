package javax.com.lallen.httpserver.parsers;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.IOException;


public class RequestParserTest {
    public RequestParser parser;
    public static final String MORE_STUFF = "zombies\r\n" +
            "run!\r\n" +
            "is an awesome game\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n";

    private String YAY_INPUT    = "Yay /zombies HTTP/1.1\r\n" +
                                  MORE_STUFF;

    @Before
    public void setUp() throws IOException {
        parser = new RequestParser(YAY_INPUT);
    }

    @Test
    public void itGivesTheVerb() throws IOException {
        assertEquals("Yay", parser.getVerb());
    }

}
