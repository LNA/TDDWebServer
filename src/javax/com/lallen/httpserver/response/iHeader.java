package javax.com.lallen.httpserver.response;

import java.io.IOException;

public interface iHeader {
    public byte[] buildResponseHead(int port) throws IOException;
}
