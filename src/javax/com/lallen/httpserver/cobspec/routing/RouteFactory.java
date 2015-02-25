package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import javax.com.lallen.httpserver.core.routing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RouteFactory {
    private final iHeader headBuilder;
    private final iBody bodyBuilder;

    public RouteFactory(iHeader headBuilder, iBody bodyBuilder) { //two differenct factories???
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
    }

    public Map<String, iResponse> buildRoutes() throws IOException {
        Map<String,iResponse> routes = new HashMap<>();
        // routes for the core
        GetRouter getRouter                           = new GetRouter(headBuilder);
        OptionsRouter optionsRouter                   = new OptionsRouter(headBuilder, bodyBuilder);
        PostRouter postRouter                         = new PostRouter(headBuilder, bodyBuilder);
        PutRouter putRouter                           = new PutRouter(headBuilder, bodyBuilder);
        DeleteRouter deleteRouter                     = new DeleteRouter(headBuilder, bodyBuilder);
        HeadRouter headRouter                         = new HeadRouter(headBuilder, bodyBuilder);

        // routes for cobspec
        GetFileRouter getFileRouter                   = new GetFileRouter(headBuilder);
        PatchFileRouter patchFileRouter               = new PatchFileRouter(headBuilder, bodyBuilder);
        RedirectRouter redirectRouter                 = new RedirectRouter(headBuilder, bodyBuilder);
        AuthenticationRouter authenticationRouter     = new AuthenticationRouter(headBuilder);
        MethodNotAllowedRouter methodNotAllowedRouter = new MethodNotAllowedRouter(headBuilder, bodyBuilder);
        PartialRouter partialRouter                   = new PartialRouter(headBuilder);
        DecodeRouter decodeRouter                     = new DecodeRouter(headBuilder);
        GetPatchRouter getPatchRouter                 = new GetPatchRouter(headBuilder, bodyBuilder);

        //adds routes for the core
        routes.put("GET", getRouter);
        routes.put("OPTIONS", optionsRouter);
        routes.put("POST", postRouter);
        routes.put("PUT", putRouter);
        routes.put("DELETE", deleteRouter);
        routes.put("HEAD", headRouter);


        //adds routes for cobSpec
        routes.put("GetFileRouter", getFileRouter);
        routes.put("PatchFileRouter", patchFileRouter);
        routes.put("REDIRECT", redirectRouter);
        routes.put("AUTHENTICATION", authenticationRouter);
        routes.put("MethodNotAllowed", methodNotAllowedRouter);
        routes.put("PARTIAL", partialRouter);
        routes.put("DECODE", decodeRouter);
        routes.put("GetPatch", getPatchRouter);

        return routes;
    }
}
