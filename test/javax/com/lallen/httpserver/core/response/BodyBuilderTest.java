package javax.com.lallen.httpserver.core.response;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.IOException;

public class BodyBuilderTest {
    public static final String UTF = "UTF-8";
    public static final String BLANK_LINE = "\r\n";

    @Test
    public void itGivesTheBody() throws IOException {
        iBody bodyBuilder = new BodyBuilder();
        byte[] responseBody = bodyBuilder.buildResponseBody();
        String body = new String(responseBody, UTF);
        assertEquals(BLANK_LINE, body);
    }

}
