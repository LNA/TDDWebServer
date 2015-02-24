package javax.com.lallen.httpserver.routing;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Router {
    private static final String PATH = "PATH";
    private final Map<String,String> request;

    public Router(Map<String,String> request) {
        this.request = request;
    }

    public String sendToRoute() {
        Map<Boolean, String> routes = buildRoutes();
        System.out.println("Request : " + request);

        if (noRouteFound(routes)) {
            return request.get("VERB");
        } else {
            return routes.get(true);
        }
    }

    private Map<Boolean, String> buildRoutes() {
        Map<Boolean, String> routes = new HashMap<>();
        routes.put(redirect(),         "REDIRECT");
        routes.put(patchFile(),        "PatchFileRouter");
        routes.put(getFile(),          "GetFileRouter");
        routes.put(authentication(),   "AUTHENTICATION");
        routes.put(methodNotAllowed(), "MethodNotAllowed");
        return routes;
    }

    private boolean noRouteFound (Map<Boolean, String> routes) {
        return routes.get(true) == null;
    }

    private boolean redirect() {
        return request.get("URI").equals("/redirect");
    }

    private boolean patchFile() {
        return new File(request.get(PATH)).isFile() && request.get("VERB").equals("PATCH");
    }

    private boolean getFile() {
        return new File(request.get(PATH)).isFile() && request.get("VERB").equals("GET");
    }

    private boolean authentication() {
        return request.get("URI").equals("/logs") || request.get("HEADERS").contains("Authentication");
    }

    private boolean methodNotAllowed() {
        return new File(request.get(PATH)).isFile() && putOrPostRequest();
    }

    private boolean putOrPostRequest() {
        return request.get("VERB").equals("PUT") || request.get("VERB").equals("POST");
    }
}