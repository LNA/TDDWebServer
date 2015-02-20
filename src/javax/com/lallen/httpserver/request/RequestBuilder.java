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
        request.put("STATUS LINE", statusLine());
        request.put("VERB", verb());
        request.put("URI", requestURI());
        request.put("DIRECTORY", directory);
        return request;
    }

    private String verb() throws IOException {
        return parser.verb();
    }

    private String requestURI() throws IOException {
        return parser.uri();
    }

    private String statusLine() throws IOException {
        return parser.statusLine();
    }
}