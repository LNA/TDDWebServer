package javax.com.lallen.httpserver.core.response;

import javax.com.lallen.httpserver.core.constants.Response;
import java.io.IOException;

public class ResponseBody implements iBody {

    @Override
    public byte[] renderBody() throws IOException {
        String body = Response.NEW_LINE;
        return body.getBytes();
    }
}