package javax.com.lallen.httpserver;

import javax.com.lallen.httpserver.server.Server;
import javax.com.lallen.httpserver.parsers.ArgsParser;
import javax.com.lallen.httpserver.sockets.HttpSocketWrapper;
import java.net.ServerSocket;
import java.io.IOException;


/**
 * Created by latoyaallen on 10/27/14.
 */
public class Main {
    public static final String PORT = "-p";
    public static final String DIRECTORY = "-d";
    public static void main(String[] args) throws Exception {

        ArgsParser argsParser = new ArgsParser();
        String port = argsParser.getArgs(args, PORT);
        int parsedPort = Integer.parseInt(port);
        String directory = argsParser.getArgs(args, DIRECTORY);
        System.out.println("The directory is: " + directory);

        Server httpServer;
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(parsedPort);

        try {
            httpServer = new Server(new HttpSocketWrapper(serverSocket), directory);
            httpServer.start();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}