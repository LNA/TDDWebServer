package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.cobspec.constants.URI;
import javax.com.lallen.httpserver.core.constants.Request;
import javax.com.lallen.httpserver.core.constants.Routes;
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
        System.out.println("Request : " + request);

        if (noRouteFound(routes)) {
            return request.get(Request.VERB);
        } else {
            return routes.get(true);
        }
    }

    private Map<Boolean, String> buildRoutes() {
        Map<Boolean, String> routes = new HashMap<>();
        routes.put(partial(),          "PARTIAL");
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
        return request.get(Request.URI).equals(URI.REDIRECT);
    }

    private boolean patchFile() {
        return new File(request.get(Request.PATH)).isFile() && request.get(Request.VERB).equals(Routes.PATCH);
    }

    public boolean getFile() {
        return getFileRequest() && !partial();
    }

    private boolean getFileRequest() {
        return new File(request.get(Request.PATH)).isFile() && request.get(Request.VERB).equals(Routes.GET);
    }

    private boolean authentication() {
        return request.get(Request.URI).equals(URI.LOGS) || request.get(Request.HEADERS).contains("Authentication");
    }

    private boolean methodNotAllowed() {
        return new File(request.get(Request.PATH)).isFile() && putOrPostRequest();
    }

    private boolean putOrPostRequest() {
        return request.get(Request.VERB).equals(Routes.PUT) || request.get(Request.VERB).equals(Routes.POST);
    }

    private boolean partial() {
        return request.get(Request.URI).equals(URI.PARTIAL_CONTENT);
    }
}