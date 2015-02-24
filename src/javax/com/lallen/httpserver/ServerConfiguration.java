package javax.com.lallen.httpserver;

import javax.com.lallen.httpserver.routing.Router;

/**
 * Created by latoyaallen on 2/23/15.
 */
public interface ServerConfiguration {
    public int port();
    public String directory();
//    public Router router();
}
