package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.response.iBody;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.BodyBuilder;
import javax.com.lallen.httpserver.response.HeadBuilder;
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
        iRouter foundRoute = router.sendTo("GET");

        assertEquals(true, foundRoute instanceof GetRouter);
    }

    @Test
    public void itHandlesAnUnknownRoute() throws IOException {
        iRouter foundRoute = router.sendTo("My Cell Phone");

        assertEquals(null, foundRoute);
    }
}
