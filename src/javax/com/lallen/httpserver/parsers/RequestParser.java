package javax.com.lallen.httpserver.parsers;

import java.util.Map;
import java.io.*;
import java.util.*;

/**
 * Created by latoyaallen on 2/10/15.
 */
public class RequestParser {

    public String getStatusLine(String input) {
        String[] lines = input.split("\r\n");
        return lines[0];
    }

    public String getVerb(String input) {
        String statusLine = getStatusLine(input);
        String[] verb = statusLine.split(" ");
        return verb[0];
    }
}
