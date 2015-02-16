package javax.com.lallen.httpserver.server;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.com.lallen.httpserver.parsers.RequestParser;
import javax.com.lallen.httpserver.request.RequestBuilder;
import javax.com.lallen.httpserver.routing.RouteFactory;
import javax.com.lallen.httpserver.routing.Router;
import javax.com.lallen.httpserver.routing.iRouter;

/**
 * Created by latoyaallen on 2/14/15.
 */
public class ConnectionHandler {
    private final ServerIO io;
    private final String directory;

    public ConnectionHandler(InputStream in, OutputStream out, String directory) throws IOException {
        this.directory = directory;
        this.io = new ServerIO(in, out);
    }

    public void run() throws IOException {
        String requestLines = io.readRequest();
        RequestParser parser = new RequestParser(requestLines);
        RequestBuilder requestBuilder = new RequestBuilder(parser);
        Map<String,String> request = requestBuilder.buildRequest();
        RouteFactory factory = new RouteFactory();
        Map<String, iRouter> routes = factory.buildRoutes();
        iRouter constructedRoute = routes.get(request.get("Verb"));
        byte[] head = constructedRoute.buildResponseHead();
        byte[] body = constructedRoute.buildResponseBody();
        io.writeResponse(head, body);
    }
}
