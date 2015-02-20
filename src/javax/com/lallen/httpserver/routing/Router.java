package javax.com.lallen.httpserver.routing;
import java.util.Map;

public class Router {
    private final Map<String,String> request;

    public Router(Map<String,String> request) {
        this.request = request;
    }

    public String sendToRoute() {
        if (request.get("URI").contains("REDIRECT")) {
            return "REDIRECT";
        } else {
            return request.get("VERB");
        }
    }
}