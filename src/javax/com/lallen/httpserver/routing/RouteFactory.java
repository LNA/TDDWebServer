package javax.com.lallen.httpserver.routing;

import javax.com.lallen.httpserver.response.iBody;
import javax.com.lallen.httpserver.response.iHeader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by latoyaallen on 2/14/15.
 */
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
        routes.put("GET", getRouter);
        routes.put("OPTIONS", optionsRouter);

        return routes;
    }
}
