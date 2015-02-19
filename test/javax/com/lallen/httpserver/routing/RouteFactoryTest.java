package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.response.*;
import java.io.IOException;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class RouteFactoryTest {
    private RouteFactory routeFactory;
    private Map<String,iResponse> routes;
    private iHeader headBuilder;
    private iBody  bodyBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new HeadBuilder();
        bodyBuilder = new BodyBuilder();
        routeFactory = new RouteFactory(headBuilder, bodyBuilder);
        routes = routeFactory.buildRoutes();
    }

    @Test
    public void itHasAGetRoute() throws IOException {
        assertEquals(true, routes.containsKey("GET"));
        assertEquals(true, routes.get("GET") instanceof GetRouter);
    }

    @Test
    public void itHasAPostRoute() throws IOException {
        assertEquals(true, routes.containsKey("POST"));
        assertEquals(true, routes.get("POST") instanceof PostRouter);
    }

    @Test
    public void itHasAnOptionsRoute() throws IOException {
        assertEquals(true, routes.containsKey("OPTIONS"));
        assertEquals(true, routes.get("OPTIONS") instanceof OptionsRouter);
    }

    @Test
    public void itHasAPutRoute() throws IOException {
        assertEquals(true, routes.containsKey("PUT"));
        assertEquals(true, routes.get("PUT") instanceof PutRouter);
    }

    @Test
    public void itHasARedirectRoute() throws IOException {
        assertEquals(true, routes.containsKey("REDIRECT"));
        assertEquals(true, routes.get("REDIRECT") instanceof RedirectRouter);
    }

    @Test
    public void itHasADeleteRoute() throws IOException {
        assertEquals(true, routes.containsKey("DELETE"));
        assertEquals(true, routes.get("DELETE") instanceof DeleteRouter);
    }
}
