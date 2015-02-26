package javax.com.lallen.httpserver.core.response;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.IOException;

public class ResponseBodyTest {
    public static final String UTF = "UTF-8";
    public static final String BLANK_LINE = "\r\n";

    @Test
    public void itGivesTheBody() throws IOException {
        iBody responseBody = new ResponseBody();
        byte[] response = responseBody.renderBody();
        String body = new String(response, UTF);
        assertEquals(BLANK_LINE, body);
    }

}
