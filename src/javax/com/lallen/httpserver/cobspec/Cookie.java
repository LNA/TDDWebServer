package javax.com.lallen.httpserver.cobspec;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by latoyaallen on 2/10/15.
 */
public class Cookie {
    public static final String VERB = "Verb";
    public static final String DATA = "Data";
    public static final String POST = "POST";
    public static final String PUT = "PUT";

    public Map<String, Object> bake(Map<String, Object> response, Map<String, Object> cookieJar) throws IOException {
        if (response.get(VERB).equals(POST)) {
            cookieJar.put(POST, response.get(DATA));
        } else if (response.get(VERB).equals(PUT)) {
            cookieJar.put(PUT, response.get(DATA));
        }
        return cookieJar;
    }
}
