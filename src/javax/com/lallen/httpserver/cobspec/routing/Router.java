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
        routes.put(paramDecode(),      "DECODE");
        routes.put(getPatchFile(),     "GetPatchFileRouter");
        routes.put(getLogRouter(),     "GetLogRouter");
        routes.put(getLogsRouter(),    "GetLogsRouter");
        return routes;
    }

    private boolean noRouteFound (Map<Boolean, String> routes) {
        return routes.get(true) == null;
    }

    private boolean redirect() {
        return request.get(Request.URI).equals(URI.REDIRECT);
    }

    private boolean patchFile() {
        return new File(request.get(Request.PATH)).isFile() && request.get(Request.URI).equals("/patch-content.txt") && request.get(Request.VERB).equals("PATCH");
    }

    public boolean getFile() {
        return getFileRequest() && !partialOrPatch();
    }

    private boolean getFileRequest() {
        return new File(request.get(Request.PATH)).isFile() && request.get(Request.VERB).equals(Routes.GET) && !request.get(Request.URI).equals("/patch-content.txt");
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

    private boolean partialOrPatch() {
        return request.get(Request.URI).equals(URI.PARTIAL_CONTENT) || request.get(Request.HEADERS).contains("If-Match");
    }

    private boolean partial() {
        return request.get(Request.URI).equals(URI.PARTIAL_CONTENT);
    }


    private boolean paramDecode() {
        return request.get(Request.URI).contains(URI.PARAMS);
    }

    private boolean getPatchFile() {
        return request.get("URI").equals("/patch-content.txt") && request.get("VERB").equals("GET");
    }

    private boolean getLogRouter() {
        return request.get("URI").equals("/log") && request.get("VERB").equals("GET");
    }

    private boolean getLogsRouter() {
        return request.get("URI").equals("/logs") && request.get("VERB").equals("GET");
    }
}