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
        } else if (foundFileFormat()) {
            return "FILE";
        } else {
            return getVerb();
        }
    }

    public String uri() {
        System.out.println(requestLines);
        String[] breakLine = splitStatusLine();
        String uri = breakLine[1];
        return uri;
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

    private boolean foundFileFormat() {
        String casedRequest = requestLines.toUpperCase();
        return casedRequest.contains("FILE");
    }
}