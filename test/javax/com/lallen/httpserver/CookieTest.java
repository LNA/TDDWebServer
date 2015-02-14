package javax.com.lallen.httpserver;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by latoyaallen on 2/10/15.
 */
public class CookieTest {
    public static final String VERB = "Verb";
    public static final String DATA = "Data";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    private Map<String, Object> response;
    private Map<String, Object> cookieJar;
    private Cookie cookie;

    @Before
    public void setUp() {
        response = new HashMap<String, Object>();
        cookieJar = new HashMap<String, Object>();
        cookie = new Cookie();

    }

    @Test
    public void itGetsCookiesForPostRequest() throws IOException {
        response.put(VERB, POST);
        response.put(DATA, "flowers & sunshine");
        cookie.bake(response, cookieJar);

        assertEquals("flowers & sunshine", cookieJar.get("POST"));
    }

    @Test
    public void itGetsCookiesForPutRequest() throws IOException {
        response.put(VERB, PUT);
        response.put(DATA, "waves & sand");
        cookie.bake(response, cookieJar);

        assertEquals("waves & sand", cookieJar.get("PUT"));
    }

    @Test
    public void itGivesNullIfNoDataFound() throws IOException {
        response.put(VERB, PUT);
        response.put(DATA, "clouds & sky");
        cookie.bake(response, cookieJar);

        assertEquals(null, cookieJar.get("POST"));
    }
}
