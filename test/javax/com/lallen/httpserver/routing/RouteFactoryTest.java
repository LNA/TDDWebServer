package javax.com.lallen.httpserver.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.response.BodyBuilder;
import javax.com.lallen.httpserver.response.HeadBuilder;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iBody;
import java.io.IOException;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class RouteFactoryTest {
    private RouteFactory routeFactory;
    private Map<String,iRouter> routes;
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
    public void itHasAGetKey() throws IOException {
        assertEquals(true, routes.containsKey("GET"));
    }

    @Test
    public void itHasAPostKey() throws IOException {
        assertEquals(true, routes.containsKey("POST"));
    }

    @Test
    public void itHasANOptionsKey() throws IOException {
        assertEquals(true, routes.containsKey("OPTIONS"));
    }

    @Test
    public void itHasAPutKey() throws IOException {
        assertEquals(true, routes.containsKey("PUT"));
    }

    @Test
    public void itHasGetRoutesValue() throws IOException {
        assertEquals(true, routes.get("GET") instanceof GetRouter);
    }

    @Test
    public void itHasOptionsRoutesValue() throws IOException {
        assertEquals(true, routes.get("OPTIONS") instanceof OptionsRouter);
    }

    @Test
    public void itHasPostRoutesValue() throws IOException {
        assertEquals(true, routes.get("POST") instanceof PostRouter);
    }

    @Test
    public void itHasPutRoutesValue() throws IOException {
        assertEquals(true, routes.get("PUT") instanceof PutRouter);
    }
}
