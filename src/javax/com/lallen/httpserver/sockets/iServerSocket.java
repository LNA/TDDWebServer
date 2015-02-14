package javax.com.lallen.httpserver.sockets;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by latoyaallen on 2/10/15.
 */
public interface iServerSocket {
    public Socket accept() throws IOException;
    public void close() throws IOException;
    public boolean isBound();
    public boolean isClosed();
}
