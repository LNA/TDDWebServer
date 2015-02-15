package javax.com.lallen.httpserver.server;

import javax.com.lallen.httpserver.sockets.iServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by latoyaallen on 2/13/15.
 */
public class Server {
    private final iServerSocket serverSocket;
    private final String directory;

    public Server(iServerSocket serverSocketWrapper, String directory) throws IOException {
        this.serverSocket = serverSocketWrapper;
        this.directory = directory;
    }

    public void start () throws IOException {
        System.out.println("Starting the server");

        while(!serverSocket.isClosed()) {
            Socket openSocket = serverSocket.accept();
        }
        serverSocket.close();
        System.out.println("Closed connection");
    }

    public boolean isBound() {
        return serverSocket.isBound();
    }

    public boolean isClosed() {
        return serverSocket.isClosed();
    }
}
