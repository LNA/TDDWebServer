package javax.com.lallen.httpserver.core.server;
import java.io.IOException;
import java.util.Map;
import javax.com.lallen.httpserver.core.parsers.RequestParser;
import javax.com.lallen.httpserver.core.request.RequestBuilder;
import javax.com.lallen.httpserver.core.response.ResponseBody;
import javax.com.lallen.httpserver.core.response.ResponseHead;
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
        System.out.println("+++++++++++++++++++++");
        String requestLines = io.readRequest();
        System.out.println("The request lines are: " + "\r\n" + requestLines);
        RequestParser parser = new RequestParser(requestLines);
        RequestBuilder requestBuilder = new RequestBuilder(parser, directory);

        Map<String, String> request = requestBuilder.buildRequest();
        ResponseHead responseHead = new ResponseHead();
        ResponseBody bodyBuilder   = new ResponseBody();

        RouteFactory routeFactory = new RouteFactory(responseHead, bodyBuilder, request);
        Map<String, iResponse> routes = routeFactory.buildRoutes();
        Router router = new Router(request);
        String requestedRoute = router.sendToRoute();
        System.out.println("The requestedRoute is: " + requestedRoute);
        iResponse response = routes.get(requestedRoute);



        byte[] head = response.renderHead(openSocket.getLocalPort());
        byte[] body = response.renderBody();
        io.writeResponse(head, body);
        System.out.println("+++++++++++++++++++++");

        openSocket.close();
    }
}
