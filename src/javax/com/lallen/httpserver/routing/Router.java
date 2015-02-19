package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iResponse;
import java.util.Map;

public class Router {
    private final Map<String,iResponse> routes;

    public Router(Map<String,iResponse> routes) {
        this.routes = routes;
    }

    public iResponse sendTo(String verb) {
        return routes.get(verb);
    }
}
