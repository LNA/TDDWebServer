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
    private final Map<String,String> request;

    public RouteFactory(iHeader headBuilder, iBody bodyBuilder, Map<String, String> request) { //two different factories???
        this.headBuilder = headBuilder;
        this.bodyBuilder = bodyBuilder;
        this.request = request;
    }

    public Map<String, iResponse> buildRoutes() throws IOException {
        Map<String,iResponse> routes = new HashMap<>();
        // routes for the core
        GetRouter getRouter                           = new GetRouter(headBuilder, request);
        OptionsRouter optionsRouter                   = new OptionsRouter(headBuilder, bodyBuilder);
        PostRouter postRouter                         = new PostRouter(headBuilder, bodyBuilder);
        PutRouter putRouter                           = new PutRouter(headBuilder, bodyBuilder);
        DeleteRouter deleteRouter                     = new DeleteRouter(headBuilder, bodyBuilder);
        HeadRouter headRouter                         = new HeadRouter(headBuilder, bodyBuilder);

        // routes for cobspec
        GetFileRouter getFileRouter                   = new GetFileRouter(headBuilder, request);
        PatchFileRouter patchFileRouter               = new PatchFileRouter(headBuilder, bodyBuilder);
        RedirectRouter redirectRouter                 = new RedirectRouter(headBuilder, bodyBuilder);
        AuthenticationRouter authenticationRouter     = new AuthenticationRouter(headBuilder);
        MethodNotAllowedRouter methodNotAllowedRouter = new MethodNotAllowedRouter(headBuilder, bodyBuilder);
        PartialRouter partialRouter                   = new PartialRouter(headBuilder, request);
        DecodeRouter decodeRouter                     = new DecodeRouter(headBuilder, request);
        GetPatchFileRouter getPatchFileRouter         = new GetPatchFileRouter(headBuilder, bodyBuilder, request);

        //adds routes for the core
        routes.put("GET", getRouter);
        routes.put("OPTIONS", optionsRouter);
        routes.put("POST", postRouter);
        routes.put("PUT", putRouter);
        routes.put("DELETE", deleteRouter);
        routes.put("HEAD", headRouter);


        //adds routes for cobSpec
        routes.put("GetFileRouter",      getFileRouter);
        routes.put("PatchFileRouter",    patchFileRouter);
        routes.put("REDIRECT",           redirectRouter);
        routes.put("AUTHENTICATION",     authenticationRouter);
        routes.put("MethodNotAllowed",   methodNotAllowedRouter);
        routes.put("PARTIAL",            partialRouter);
        routes.put("DECODE",             decodeRouter);
        routes.put("GetPatchFileRouter", getPatchFileRouter);

        return routes;
    }
}