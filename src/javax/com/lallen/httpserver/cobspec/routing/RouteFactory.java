package javax.com.lallen.httpserver.cobspec.routing;
import javax.com.lallen.httpserver.core.response.iBody;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import javax.com.lallen.httpserver.core.routing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RouteFactory {
    private final iHeader ResponseHead;
    private final iBody   ResponseBody;
    private final Map<String,String> request;

    public RouteFactory(iHeader ResponseHead, iBody ResponseBody, Map<String, String> request) { //two different factories???
        this.ResponseHead = ResponseHead;
        this.ResponseBody = ResponseBody;
        this.request      = request;
    }

    public Map<String, iResponse> buildRoutes() throws IOException {
        Map<String,iResponse> routes = new HashMap<>();
        // routes for the core
        GetRouter getRouter                           = new GetRouter(ResponseHead, request);
        OptionsRouter optionsRouter                   = new OptionsRouter(ResponseHead, ResponseBody);
        PostRouter postRouter                         = new PostRouter(ResponseHead, ResponseBody);
        PutRouter putRouter                           = new PutRouter(ResponseHead, ResponseBody);
        DeleteRouter deleteRouter                     = new DeleteRouter(ResponseHead, ResponseBody);
        HeadRouter headRouter                         = new HeadRouter(ResponseHead, ResponseBody);

        // routes for cobspec
        GetFileRouter getFileRouter                   = new GetFileRouter(ResponseHead, request);
        PatchFileRouter patchFileRouter               = new PatchFileRouter(ResponseHead, ResponseBody);
        RedirectRouter redirectRouter                 = new RedirectRouter(ResponseHead, ResponseBody);
        AuthenticationRouter authenticationRouter     = new AuthenticationRouter(ResponseHead);
        MethodNotAllowedRouter methodNotAllowedRouter = new MethodNotAllowedRouter(ResponseHead, ResponseBody);
        PartialRouter partialRouter                   = new PartialRouter(ResponseHead, request);
        DecodeRouter decodeRouter                     = new DecodeRouter(ResponseHead, request);
        GetPatchFileRouter getPatchFileRouter         = new GetPatchFileRouter(ResponseHead, request);
        GetLogRouter getLogRouter                     = new GetLogRouter(ResponseHead, ResponseBody);
        GetLogsRouter getLogsRouter                   = new GetLogsRouter(ResponseHead);


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
        routes.put("GetLogRouter",       getLogRouter);
        routes.put("GetLogsRouter",      getLogsRouter);

        return routes;
    }
}