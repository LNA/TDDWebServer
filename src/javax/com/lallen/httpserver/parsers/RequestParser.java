package javax.com.lallen.httpserver.parsers;

public class RequestParser {

    private final String requestLines;

    public RequestParser(String requestLines) {
        this.requestLines = requestLines;
    }

    public String requestType() {
        String statusLine = getStatusLine();
        if (statusLine.contains("redirect")) {
            return "REDIRECT";
        } else {
            return getVerb();
        }
    }

    private String getStatusLine() {
        String[] lines = requestLines.split("\r\n");
        return lines[0];
    }

    private String getVerb() {
        String statusLine = getStatusLine();
        String[] verb = statusLine.split(" ");
        String casedVerb = verb[0].toUpperCase();
        return casedVerb;
    }
}
