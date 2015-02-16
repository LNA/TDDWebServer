package javax.com.lallen.httpserver.routing;

import java.io.IOException;

/**
 * Created by latoyaallen on 2/14/15.
 */
public interface iRouter {
    public byte[] buildResponseHead() throws IOException;
}
