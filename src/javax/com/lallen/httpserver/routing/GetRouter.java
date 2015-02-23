package javax.com.lallen.httpserver.routing;
import javax.com.lallen.httpserver.response.iHeader;
import javax.com.lallen.httpserver.response.iResponse;
import java.io.IOException;

import java.util.Map;
import java.io.File;


public class GetRouter implements iResponse {
    public static final String STATUS = "HTTP/1.1 200 OK\r\n";
    private final iHeader headBuilder;

    public GetRouter(iHeader headBuilder) {
        this.headBuilder = headBuilder;
    }

    @Override
    public byte[] buildResponseHead(int port) throws IOException {
        return headBuilder.buildResponseHead(port, STATUS);
    }

    @Override
    public byte[] buildResponseBody(Map<String, String> request) throws IOException {
        String path = request.get("PATH");
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        String links;
        links = "<html><head><title></title></head><body>";

        for (File file : listOfFiles) {
            if (file.isFile()) {
               links += "<a href=\"" + "/" + fileName(file) + "\">" + fileName(file) + "</a></br>";
            }
        }
        links += "</body></html>";

        return links.getBytes();
    }

    private String fileName(File file) throws IOException {
        return file.getName();
    }
}