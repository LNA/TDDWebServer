package javax.com.lallen.httpserver.parsers;

import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.parsers.RequestParser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

/**
 * Created by latoyaallen on 2/10/15.
 */
public class RequestParserTest {
    public static final String MORE_STUFF = "zombies\r\n" +
            "run!\r\n" +
            "is an awesome game\r\n" +
            "\r\n" +
            "\r\n" +
            "\r\n";

    private String GET_INPUT    = "GET /zombies HTTP/1.1\r\n" +
                                  MORE_STUFF;

    @Test
    public void itGivesTheStatusLine() throws IOException {
        RequestParser parser = new RequestParser();
        assertEquals("GET /zombies HTTP/1.1", parser.getStatusLine(GET_INPUT));
    }

}
