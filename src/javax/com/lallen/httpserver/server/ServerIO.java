package javax.com.lallen.httpserver.server;
import java.io.*;

/**
 * Created by latoyaallen on 2/13/15.
 */
public class ServerIO {
    private final InputStream openSocket;

    public ServerIO(InputStream openSocket) {
        this.openSocket = openSocket;
    }
    public String readRequest() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(openSocket));
        String request = "";
        do request += (char) reader.read(); while (reader.ready());
        return request;
    }
}
