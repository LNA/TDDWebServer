package javax.com.lallen.httpserver.routing;
import org.junit.Test;
import java.io.IOException;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class RouteFactoryTest {

    @Test
    public void itHasAGetKey() throws IOException {
        RouteFactory routeFactory = new RouteFactory();
        Map<String,iRouter> routes = routeFactory.buildRoutes();
        assertEquals(true, routes.containsKey("Get"));
    }

    @Test
    public void itHasGetRoutesValue() throws IOException {
        RouteFactory routeFactory = new RouteFactory();
        Map<String,iRouter> routes = routeFactory.buildRoutes();

        assertEquals(true, routes.get("Get") instanceof GetRouter);

    }
}
