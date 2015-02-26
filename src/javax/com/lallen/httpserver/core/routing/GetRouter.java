package javax.com.lallen.httpserver.core.routing;
import javax.com.lallen.httpserver.core.constants.Status;
import javax.com.lallen.httpserver.core.response.iHeader;
import javax.com.lallen.httpserver.core.response.iResponse;
import java.io.IOException;

import java.util.Map;
import java.io.File;

public class GetRouter implements iResponse {
    private final iHeader responseHead;
    private final Map<String,String> request;

    public GetRouter(iHeader responseHead, Map<String, String> request) {
        this.responseHead = responseHead;
        this.request = request;
    }

    @Override
    public byte[] renderHead(int port) throws IOException {
        File[] listOfFiles = findFiles();
        if (noFilesFound(findFiles())) {
            return responseHead.renderHead(port, Status.NOT_FOUND);
        } else {
            return responseHead.renderHead(port, Status.OK);
        }

    }

    @Override
    public byte[] renderBody() throws IOException {
        File[] listOfFiles = findFiles();
        if (noFilesFound(findFiles())) {
            return blankPage();
        } else {
            return bodyLinks(listOfFiles);
        }
    }

    private File[] findFiles() throws IOException {
        String path = request.get("PATH");
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        return listOfFiles;
    }

    private byte[] blankPage() throws IOException {
        String body = "";
        return body.getBytes();
    }

    private String fileName(File file) throws IOException {
        return file.getName();
    }

    private boolean noFilesFound(File[] listOfFiles) throws IOException {
        return listOfFiles == null;
    }

    private byte[] bodyLinks(File[] listOfFiles) throws IOException {
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
}