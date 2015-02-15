package javax.com.lallen.httpserver.routing;
import java.util.Map;

public class Router {
    private final Map<String,iRouter> routes;

    public Router(Map<String,iRouter> routes) {
        this.routes = routes;
    }

    public iRouter sendTo(String verb) {
        return routes.get(verb);
    }
}
