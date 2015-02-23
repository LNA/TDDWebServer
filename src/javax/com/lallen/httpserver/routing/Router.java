package javax.com.lallen.httpserver.routing;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Router {
    private final Map<String,String> request;

    public Router(Map<String,String> request) {
        this.request = request;
    }

    public String sendToRoute() {
        if (request.get("URI").equals("REDIRECT")) {
            return "REDIRECT";
        } else if (patchFile()) {
            return "PatchFileRouter";
        } else if (getFile()) {
            return "GetFileRouter";
        } else {
            return request.get("VERB");
        }
    }

    private boolean patchFile() {
        return new File(request.get("PATH")).isFile() && request.get("VERB").equals("PATCH");
    }

    private boolean getFile() {
        return new File(request.get("PATH")).isFile() && request.get("VERB").equals("GET");
    }
}