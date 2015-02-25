package javax.com.lallen.httpserver.cobspec.routing;

import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;
import java.util.Map;
import java.net.URLDecoder;

public class DecodeRouter implements iResponse {

    private final iHeader headBuilder;

    public DecodeRouter(iHeader headBuilder) {
        this.headBuilder = headBuilder;
    }
    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, Status.OK);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        String decodedURI = URLDecoder.decode(request.get("URI"), "utf-8");
        String params = buildLine(decodedURI);
        byte[] body = params.getBytes();
        return body;
    }
    private String buildLine(String decodedURI) throws IOException {
        String decodedParams = decodedURI.substring(decodedURI.indexOf("?")+1);
        String firstVariable = decodedParams.substring(0, decodedParams.lastIndexOf("&"));
        String secondVariable = decodedParams.replaceAll(".*&", "");
        String params = constructLine(firstVariable, secondVariable);
        return params;
    }

    private String constructLine(String firstVariable, String secondVariable) throws IOException { //name
        String lineOne = padEqualSign(firstVariable);
        String lineTwo = padEqualSign(secondVariable);
        String params = lineOne + "\r\n" + lineTwo;
        return params;
    }

    private String padEqualSign(String string) throws IOException {
        String line = string.replaceFirst("=", " = ");
        return line;
    }
}