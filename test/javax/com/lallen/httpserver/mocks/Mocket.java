package javax.com.lallen.httpserver.mocks;

import java.io.InputStream;
import java.io.OutputStream;


/**
 * Created by latoyaallen on 2/10/15.
 */
public class Mocket {
    private InputStream inputStream;
    private OutputStream outputStream;

    public Mocket(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
