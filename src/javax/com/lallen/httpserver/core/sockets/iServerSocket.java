package javax.com.lallen.httpserver.core.sockets;

import java.io.IOException;
import java.net.Socket;

public interface iServerSocket {
    public Socket accept() throws IOException;
    public void close() throws IOException;
    public boolean isBound();
    public boolean isClosed();
}
