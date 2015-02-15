package javax.com.lallen.httpserver.routing;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class RouterTest {

    @Test
    public void itGivesAnInstanceOfGetRouter() throws IOException {
        RouteFactory routeFactory = new RouteFactory();
        Router router = new Router(routeFactory.buildRoutes());
        iRouter foundRoute = router.sendTo("Get");

        assertEquals(true, foundRoute instanceof GetRouter);
    }

    @Test
    public void itHandlesAnUnknownRoute() throws IOException {
        RouteFactory routeFactory = new RouteFactory();
        Router router = new Router(routeFactory.buildRoutes());
        iRouter foundRoute = router.sendTo("My Cell Phone");

        assertEquals(null, foundRoute);
    }
}
