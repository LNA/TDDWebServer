package javax.com.lallen.httpserver.routing;

import javax.com.lallen.httpserver.response.HeadBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by latoyaallen on 2/14/15.
 */
public class RouteFactory {
    private final HeadBuilder headBuilder;

    public RouteFactory(HeadBuilder headBuilder) {
        this.headBuilder = headBuilder;
    }

    public Map<String, iRouter> buildRoutes() throws IOException {
        Map<String,iRouter> routes = new HashMap<>();
        GetRouter getRouter = new GetRouter(headBuilder);
        OptionsRouter optionsRouter = new OptionsRouter(headBuilder);
        routes.put("GET", getRouter);
        routes.put("OPTIONS", optionsRouter);

        return routes;
    }
}
