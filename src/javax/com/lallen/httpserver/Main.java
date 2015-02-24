package javax.com.lallen.httpserver;
import javax.com.lallen.httpserver.routing.Router;
import javax.com.lallen.httpserver.server.Server;
import javax.com.lallen.httpserver.parsers.ArgsParser;
import javax.com.lallen.httpserver.sockets.HttpSocketWrapper;
import java.net.ServerSocket;
import java.io.IOException;
import java.util.logging.FileHandler;

public class Main {
    public static final String PORT = "-p";
    public static final String DIRECTORY = "-d";
    public static void main(String[] args) throws Exception {

        CobSpecConfiguration configuration = new CobSpecConfiguration(args);
//        ArgsParser argsParser = new ArgsParser();
//        String port = argsParser.getArgs(args, PORT);
//        int parsedPort = Integer.parseInt(port);
//        String directory = argsParser.getArgs(args, DIRECTORY);
        System.out.println("The directory is: " + configuration.directory());
        System.out.println("The port is: " + configuration.port());


        Server httpServer;
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(configuration.port());

        httpServer = new Server(new HttpSocketWrapper(serverSocket), configuration.directory());
        httpServer.start();
    }

    public static class CobSpecConfiguration implements ServerConfiguration {
        public CobSpecConfiguration(String[] args) {

        }

        @Override
        public int port() {
            return 123;
        }

        @Override
        public String directory() {
            return null;
        }

        @Override
        public Router router() {
            return new RouterBuilder()
                    .addRoute("GET", "/search", new SearchHandler())
                    .addRoute("GET", "/v2/search", new SearchHandler())

                    .addRoute("GET", "/file.jpg", new FileHandler()) //tedious - belongs in "core" HTTP server
                    .addRoute("GET", "/file2.png", new FileHandler()) //tedious - belongs in "core" HTTP server
                    .addRoute("GET", "/foobar", new EmptyResponse())
                    //.addRoute("GET", "/", new )
                    .build();
        }

        private class RouterBuilder {
        }
    }
}