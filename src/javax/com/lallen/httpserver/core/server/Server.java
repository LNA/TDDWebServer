package javax.com.lallen.httpserver.core.server;
import javax.com.lallen.httpserver.core.sockets.iServerSocket;
import java.io.IOException;
import java.net.Socket;

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
            try {
            Socket openSocket = serverSocket.accept();
            ConnectionHandler connectionHandler = new ConnectionHandler(openSocket, directory);
            connectionHandler.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
