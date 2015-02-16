package javax.com.lallen.httpserver.routing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by latoyaallen on 2/14/15.
 */
public class RouteFactory {
    public Map<String, iRouter> buildRoutes() throws IOException {
        Map<String,iRouter> routes = new HashMap<>();
        GetRouter getRouter = new GetRouter();
        routes.put("GET", getRouter);

        return routes;
    }
}
