package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iBody;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RouteFactory {
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public RouteFactory(iHeader headBuilder, iBody bodyBuilder) {
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
    }

    public Map<String, iResponse> buildRoutes() throws IOException {
        Map<String,iResponse> routes = new HashMap<>();

        GetRouter getRouter = new GetRouter(headBuilder);
        GetFileRouter getFileRouter = new GetFileRouter(headBuilder);
        PatchFileRouter patchFileRouter = new PatchFileRouter(headBuilder, bodyBuilder);
        OptionsRouter optionsRouter = new OptionsRouter(headBuilder, bodyBuilder);
        PostRouter postRouter = new PostRouter(headBuilder, bodyBuilder);
        PutRouter putRouter = new PutRouter(headBuilder, bodyBuilder);
        HeadRouter headRouter = new HeadRouter(headBuilder, bodyBuilder);
        RedirectRouter redirectRouter = new RedirectRouter(headBuilder, bodyBuilder);
        DeleteRouter deleteRouter = new DeleteRouter(headBuilder, bodyBuilder);
        AuthenticationRouter authenticationRouter = new AuthenticationRouter(headBuilder);

        routes.put("GET", getRouter);
        routes.put("GetFileRouter", getFileRouter);
        routes.put("PatchFileRouter", patchFileRouter);
        routes.put("OPTIONS", optionsRouter);
        routes.put("POST", postRouter);
        routes.put("PUT", putRouter);
        routes.put("HEAD", headRouter);
        routes.put("REDIRECT", redirectRouter);
        routes.put("DELETE", deleteRouter);
        routes.put("AUTHENTICATION", authenticationRouter);

        return routes;
    }
}
