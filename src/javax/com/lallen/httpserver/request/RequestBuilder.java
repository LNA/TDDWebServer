package javax.com.lallen.httpserver.request;
import javax.com.lallen.httpserver.parsers.RequestParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {
    public Map<String,String> request;
    public RequestParser parser;

    public RequestBuilder(RequestParser parser) throws IOException {
        this.parser = parser;
    }

    public Map<String,String> buildRequest() throws IOException {
        Map<String,String> request = new HashMap<String, String>();
        request.put("Type", requestType());
        return request;
    }

    public String requestType() throws IOException {
        return parser.requestType();
    }
}