package javax.com.lallen.httpserver.response;

import java.io.IOException;

public class BodyBuilder implements iBody {
    @Override
    public byte[] buildResponseBody() throws IOException {
        return new byte[0];
    }
}
