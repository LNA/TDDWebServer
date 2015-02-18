package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iBody;
import javax.com.lallen.httpserver.response.iHeader;
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

    public Map<String, iRouter> buildRoutes() throws IOException {
        Map<String,iRouter> routes = new HashMap<>();

        GetRouter getRouter = new GetRouter(headBuilder, bodyBuilder);
        OptionsRouter optionsRouter = new OptionsRouter(headBuilder, bodyBuilder);
        PostRouter postRouter = new PostRouter(headBuilder, bodyBuilder);
        PutRouter putRouter = new PutRouter(headBuilder, bodyBuilder);
        HeadRouter headRouter = new HeadRouter(headBuilder, bodyBuilder);
        RedirectRouter redirectRouter = new RedirectRouter(headBuilder, bodyBuilder);

        routes.put("GET", getRouter);
        routes.put("OPTIONS", optionsRouter);
        routes.put("POST", postRouter);
        routes.put("PUT", putRouter);
        routes.put("HEAD", headRouter);
        routes.put("REDIRECT", redirectRouter);

        return routes;
    }
}
