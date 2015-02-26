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
        Map<String, String> request = generateRequest();
        iResponse response          = generateResponse(request);
        write(response);
        System.out.print("I sent a response. In return, I'd like chocolate.  Preferably dark chocolate.\r\n");
        openSocket.close();
    }

    public Map<String, String> generateRequest() throws IOException {
        String requestLines           = io.readRequest();
        RequestParser parser          = new RequestParser(requestLines);
        RequestBuilder requestBuilder = new RequestBuilder(parser, directory);
        Map<String, String> request   = requestBuilder.buildRequest();
        return request;
    }

    public iResponse generateResponse(Map<String, String> request) throws IOException {
        ResponseHead responseHead     = new ResponseHead();
        ResponseBody bodyBuilder      = new ResponseBody();
        RouteFactory routeFactory     = new RouteFactory(responseHead, bodyBuilder, request);
        Map<String, iResponse> routes = routeFactory.buildRoutes();
        Router router                 = new Router(request);
        String requestedRoute         = router.sendToRoute();
        iResponse response            = routes.get(requestedRoute);
        return response;
    }

    public void write(iResponse response) throws IOException {
        byte[] head = response.renderHead(openSocket.getLocalPort());
        byte[] body = response.renderBody();
        io.writeResponse(head, body);
    }
}