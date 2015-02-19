package javax.com.lallen.httpserver.response;

import java.io.IOException;

public class BodyBuilder implements iBody {
    public static final String BLANK_LINE = "\r\n";

    @Override
    public byte[] buildResponseBody() throws IOException {
        String body = BLANK_LINE;
        return body.getBytes();
    }
}
