package javax.com.lallen.httpserver.core.parsers;

import javax.com.lallen.httpserver.core.constants.Request;

public class RequestParser {

    private final String requestLines;

    public RequestParser(String requestLines) {
        this.requestLines = requestLines;
    }

    public String statusLine() {
        String[] lines = requestLines.split("\r\n");
        return lines[0];
    }

    public String resource() {
        String statusLine = statusLine();
        String[] words = statusLine.split(" ");
        return words[0] + words[1];
    }

    public String verb() {
        String statusLine = statusLine();
        String[] verb = statusLine.split(" ");
        String casedVerb = verb[0].toUpperCase();
        return casedVerb;
    }

    public String uri() {
        String[] breakLine = splitStatusLine();
        String uri = breakLine[1];
        return uri;
    }

    private String[] splitStatusLine() {
        String[] lines = splitHeaders();
        String statusLine = lines[0];
        String[] statusLines = statusLine.split(" ");
        return statusLines;
    }

    private String[] splitHeaders() {
        String[] headerLines = requestLines.split("\r\n");
        return headerLines;
    }

    public String headers() {
        String[] headers = splitHeaders();
        return headers[1];
    }

    public String range() {
        String headers = headers();
        if (headers.contains(Request.BYTE)) {
            String range = headers.split("-")[1];
            return range;
        } else {
            return " ";
        }
    }

    public String etag() {
        String headers = headers();
        if (headers.contains("If-Match")) {
            String etag = headers.split(": ")[1];
            return etag;
        } else {
            return " ";
        }
    }
}