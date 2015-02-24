package javax.com.lallen.httpserver.core.server;
import java.io.IOException;
import java.util.Map;
import javax.com.lallen.httpserver.core.parsers.RequestParser;
import javax.com.lallen.httpserver.core.request.RequestBuilder;
import javax.com.lallen.httpserver.core.response.BodyBuilder;
import javax.com.lallen.httpserver.core.response.HeadBuilder;
import javax.com.lallen.httpserver.cobspec.routing.RouteFactory;
import javax.com.lallen.httpserver.cobspec.routing.Router;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.net.Socket;

public class ConnectionHandler {
    private final ServerIO io;
    private final String directory;
    private final Socket openSocket;

    public ConnectionHandler(Socket openSocket, String directory) throws IOException {
        this.openSocket = openSocket;
        this.directory = directory;
        this.io = new ServerIO(openSocket.getInputStream(), openSocket.getOutputStream());
    }

    public void run() throws IOException {
        String requestLines = io.readRequest();
        System.out.println("The request lines are: " + "" + requestLines);
        RequestParser parser = new RequestParser(requestLines);
        RequestBuilder requestBuilder = new RequestBuilder(parser, directory);

        Map<String, String> request = requestBuilder.buildRequest();
        HeadBuilder headBuilder   = new HeadBuilder();
        BodyBuilder bodyBuilder   = new BodyBuilder();

        RouteFactory routeFactory = new RouteFactory(headBuilder, bodyBuilder);
        Map<String, iResponse> routes = routeFactory.buildRoutes();
        Router router = new Router(request);
        String requestedRoute = router.sendToRoute();
        System.out.println("The requestedRoute is: " + requestedRoute);
        System.out.println("+++++++++++++++++++++");
        iResponse response = routes.get(requestedRoute);
        System.out.println(":response: " + response );
        byte[] head = response.buildResponseHead(openSocket.getLocalPort());
        byte[] body = response.buildResponseBody(request);
        io.writeResponse(head, body);
        openSocket.close();
    }
}