package javax.com.lallen.httpserver.cobspec.routing;
import org.junit.Before;
import org.junit.Test;

import javax.com.lallen.httpserver.core.response.*;
import javax.com.lallen.httpserver.core.routing.*;
import java.io.IOException;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class RouteFactoryTest {
    private RouteFactory routeFactory;
    private Map<String,iResponse> routes;
    public Map<String, String> request;
    private iHeader headBuilder;
    private iBody  bodyBuilder;

    @Before
    public void setUp() throws IOException {
        headBuilder = new HeadBuilder();
        bodyBuilder = new BodyBuilder();
        routeFactory = new RouteFactory(headBuilder, bodyBuilder, request);
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

    @Test
    public void itHasAMethodNotAllowedRoute() throws IOException {
        assertEquals(true, routes.containsKey("MethodNotAllowed"));
        assertEquals(true, routes.get("MethodNotAllowed") instanceof MethodNotAllowedRouter);
    }

    @Test
    public void itHasAPartialRoute() throws IOException {
        assertEquals(true, routes.containsKey("PARTIAL"));
        assertEquals(true, routes.get("PARTIAL") instanceof PartialRouter);
    }

    @Test
    public void itHasAGetPatchFileRoute() throws IOException {
        assertEquals(true, routes.containsKey("GetPatchFileRouter"));
        assertEquals(true, routes.get("GetPatchFileRouter") instanceof GetPatchFileRouter);
    }

    @Test
    public void itHasAGetLogeRoute() throws IOException {
        assertEquals(true, routes.containsKey("GetLogRouter"));
        assertEquals(true, routes.get("GetLogRouter") instanceof GetLogRouter);
    }
}