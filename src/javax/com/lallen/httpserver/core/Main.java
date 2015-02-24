package javax.com.lallen.httpserver.core;
import javax.com.lallen.httpserver.cobspec.parsers.ArgsParser;
import javax.com.lallen.httpserver.cobspec.CobSpecConfiguration;
import javax.com.lallen.httpserver.core.server.Server;
import javax.com.lallen.httpserver.core.sockets.HttpSocketWrapper;
import java.net.ServerSocket;


public class Main {
    public static void main(String[] args) throws Exception {

        ArgsParser argsParser              = new ArgsParser();
        CobSpecConfiguration configuration = new CobSpecConfiguration(args, argsParser);

        System.out.println("The directory is: " + configuration.directory());
        System.out.println("The port is: "      + configuration.port());


        Server httpServer;
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(configuration.port());

        httpServer = new Server(new HttpSocketWrapper(serverSocket), configuration.directory());
        httpServer.start();
    }
}