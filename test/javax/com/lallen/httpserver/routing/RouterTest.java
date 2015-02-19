package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.response.*;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RouterTest {
    private RouteFactory routeFactory;
    private Router router;
    private iHeader headBuilder;
    private iBody bodyBuilder;

    @Before
    public void setUp() throws IOException {
        bodyBuilder = new BodyBuilder();
        headBuilder = new HeadBuilder();
        routeFactory = new RouteFactory(headBuilder, bodyBuilder);
        router = new Router(routeFactory.buildRoutes());
    }

    @Test
    public void itGivesAnInstanceOfGetRouter() throws IOException {
        iResponse foundRoute = router.sendTo("GET");

        assertEquals(true, foundRoute instanceof GetResponse);
    }

    @Test
    public void itHandlesAnUnknownRoute() throws IOException {
        iResponse foundRoute = router.sendTo("My Cell Phone");

        assertEquals(null, foundRoute);
    }
}
