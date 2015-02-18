package javax.com.lallen.httpserver.server;
import java.io.IOException;
import java.util.Map;
import javax.com.lallen.httpserver.parsers.RequestParser;
import javax.com.lallen.httpserver.request.RequestBuilder;
import javax.com.lallen.httpserver.response.BodyBuilder;
import javax.com.lallen.httpserver.response.HeadBuilder;
import javax.com.lallen.httpserver.routing.RouteFactory;
import javax.com.lallen.httpserver.routing.iRouter;
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
        Map<String, String>request = buildRequest();
        iRouter constructedRoute = route(request);
        sendResponseFor(constructedRoute);
        openSocket.close();
    }

    public Map<String, String> buildRequest() throws IOException {
        String requestLines = io.readRequest();
        System.out.println("The request lines are: " + requestLines);
        RequestParser parser = new RequestParser(requestLines);
        RequestBuilder requestBuilder = new RequestBuilder(parser);
        Map<String,String> request = requestBuilder.buildRequest();
        System.out.println("The request: " + request);
        return request;
    }

    public iRouter route(Map<String, String> request) throws IOException {
        HeadBuilder headBuilder = new HeadBuilder();
        BodyBuilder bodyBuilder = new BodyBuilder();
        RouteFactory factory = new RouteFactory(headBuilder, bodyBuilder);
        Map<String, iRouter> routes = factory.buildRoutes(); //add routes here
        iRouter constructedRoute = routes.get(request.get("Type"));
        return constructedRoute;
    }

    public void sendResponseFor(iRouter constructedRoute) throws IOException {
        byte[] head = constructedRoute.buildResponseHead(openSocket.getLocalPort());
        byte[] body = constructedRoute.buildResponseBody();
        io.writeResponse(head, body);
    }
}
