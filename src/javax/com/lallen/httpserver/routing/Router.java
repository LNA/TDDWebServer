package javax.com.lallen.httpserver.routing;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private final Map<String,String> request;

    public Router(Map<String,String> request) {
        this.request = request;
    }

    public String sendToRoute() {
        Map<Boolean, String> routes = buildRoutes();
        System.out.println(request);

        if (noRouteFound(routes)) {
            return request.get("VERB");
        } else {
            return routes.get(true);
        }
    }

    private Map<Boolean, String> buildRoutes() {
        Map<Boolean, String> routes = new HashMap<>();
        routes.put(redirect(),       "REDIRECT");
        routes.put(patchFile(),      "PatchFileRouter");
        routes.put(getFile(),        "GetFileRouter");
        routes.put(redirect(),       "REDIRECT");
        routes.put(authentication(), "AUTHENTICATION");
        return routes;
    }

    private boolean noRouteFound (Map<Boolean, String> routes) {
        return routes.get(true) == null;
    }

    private boolean redirect() {
        return request.get("URI").equals("REDIRECT");
    }

    private boolean patchFile() {
        return new File(request.get("PATH")).isFile() && request.get("VERB").equals("PATCH");
    }

    private boolean getFile() {
        return new File(request.get("PATH")).isFile() && request.get("VERB").equals("GET");
    }

    private boolean authentication() {
        return request.get("URI").equals("/logs") || request.get("HEADERS").contains("Authentication");
    }
}