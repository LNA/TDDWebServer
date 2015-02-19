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

        GetResponse getRouter = new GetResponse(headBuilder, bodyBuilder);
        OptionsResponse optionsRouter = new OptionsResponse(headBuilder, bodyBuilder);
        PostResponse postRouter = new PostResponse(headBuilder, bodyBuilder);
        PutResponse putRouter = new PutResponse(headBuilder, bodyBuilder);
        HeadResponse headRouter = new HeadResponse(headBuilder, bodyBuilder);
        RedirectResponse redirectRouter = new RedirectResponse(headBuilder, bodyBuilder);
        FileResponse fileRouter = new FileResponse(headBuilder, bodyBuilder);

        routes.put("GET", getRouter);
        routes.put("OPTIONS", optionsRouter);
        routes.put("POST", postRouter);
        routes.put("PUT", putRouter);
        routes.put("HEAD", headRouter);
        routes.put("REDIRECT", redirectRouter);
        routes.put("FILE", fileRouter);

        return routes;
    }
}
