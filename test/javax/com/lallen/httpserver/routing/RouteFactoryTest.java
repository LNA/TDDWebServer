package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class RouteFactoryTest {
    private RouteFactory routeFactory;
    private Map<String,iRouter> routes;

    @Before
    public void setUp() throws IOException {
        routeFactory = new RouteFactory();
        routes = routeFactory.buildRoutes();
    }

    @Test
    public void itHasAGetKey() throws IOException {
        assertEquals(true, routes.containsKey("GET"));
    }

    @Test
    public void itHasGetRoutesValue() throws IOException {
        assertEquals(true, routes.get("GET") instanceof GetRouter);

    }
}
