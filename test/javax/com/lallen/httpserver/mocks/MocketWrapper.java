package javax.com.lallen.httpserver.mocks;

import javax.com.lallen.httpserver.core.sockets.iServerSocket;
import java.io.*;
import java.net.Socket;

/**
 * Created by latoyaallen on 2/10/15.
 */
public class MocketWrapper implements iServerSocket {
    private Mocket mocket;
    private boolean closed;


    public MocketWrapper(Mocket mocket) {
        this.mocket = mocket;
    }

    @Override
    public Socket accept() throws IOException {
        return null;
    }

    @Override
    public void close() throws IOException {
        closed = true;

    }

    @Override
    public boolean isBound() {
        return true;
    }

    @Override
    public boolean isClosed() {
        return true;
    }
}
