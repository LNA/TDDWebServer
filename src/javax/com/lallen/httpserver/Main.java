package javax.com.lallen.httpserver;
import javax.com.lallen.httpserver.server.Server;
import javax.com.lallen.httpserver.parsers.ArgsParser;
import javax.com.lallen.httpserver.sockets.HttpSocketWrapper;
import java.net.ServerSocket;
import java.io.IOException;

public class Main {
    public static final String PORT = "-p";
    public static final String DIRECTORY = "-d";
    public static void main(String[] args) throws Exception {

        ArgsParser argsParser = new ArgsParser();
        String port = argsParser.getArgs(args, PORT);
        int parsedPort = Integer.parseInt(port);
        String directory = argsParser.getArgs(args, DIRECTORY);
        System.out.println("The directory is: " + directory);
        System.out.println("The port is: " + port);


        Server httpServer;
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(parsedPort);

        httpServer = new Server(new HttpSocketWrapper(serverSocket), directory);
        httpServer.start();
    }
}