package javax.com.lallen.httpserver.server;
import java.io.*;
import java.io.DataOutputStream;

/**
 * Created by latoyaallen on 2/13/15.
 */
public class ServerIO {
    private final InputStream in;
    private final OutputStream out;

    public ServerIO(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    public String readRequest() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String request = "";
        do request += (char) reader.read(); while (reader.ready());
        return request;
    }

    public void writeResponse(byte[] head, byte[] body) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(out);
        byte[] response = concatenateByteArrays(head, body);
        outputStream.write(response);
        outputStream.flush();
    }

    private byte[] concatenateByteArrays(byte[] head, byte[] body) {
        byte[] result = new byte[head.length + body.length];
        System.arraycopy(head, 0, result, 0, head.length);
        System.arraycopy(body, 0, result, head.length, body.length);
        return result;
    }
}
