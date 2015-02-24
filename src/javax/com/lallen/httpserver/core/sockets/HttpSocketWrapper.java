package javax.com.lallen.httpserver.core.sockets;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpSocketWrapper implements iServerSocket {
    private ServerSocket serverSocket;

     public HttpSocketWrapper(ServerSocket serverSocket) {
         this.serverSocket = serverSocket;
     }

    @Override
    public boolean isClosed() {
        return serverSocket.isClosed();
    }

    @Override
    public Socket accept() throws IOException {
        return serverSocket.accept();
    }

    @Override
    public void close() throws IOException {
        serverSocket.close();
    }

    @Override
    public boolean isBound() {
        return false;
    }
}
