package javax.com.lallen.httpserver.request;
import javax.com.lallen.httpserver.parsers.RequestParser;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {
    public RequestParser parser;
    public String directory;

    public RequestBuilder(RequestParser parser, String directory) throws IOException {
        this.parser = parser;
        this.directory = directory;
    }

    public Map<String,String> buildRequest() throws IOException {
        Map<String,String> request = new HashMap<String, String>();
        request.put("TYPE", requestType());
        request.put("URI", requestURI());
        request.put("DIRECTORY", directory);
        return request;
    }

    public String requestType() throws IOException {
        return parser.requestType();
    }

    public String requestURI() throws IOException {
        return parser.uri();
    }
}