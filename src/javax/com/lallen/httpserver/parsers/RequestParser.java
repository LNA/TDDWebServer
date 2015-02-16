package javax.com.lallen.httpserver.parsers;

public class RequestParser {
    public final String requestLines;

    public RequestParser(String requestLines) {
        this.requestLines = requestLines;
    }

    private String getStatusLine() {
        String[] lines = requestLines.split("\r\n");
        return lines[0];
    }

    public String getVerb() {
        String statusLine = getStatusLine();
        String[] verb = statusLine.split(" ");
        return verb[0];
    }
}
