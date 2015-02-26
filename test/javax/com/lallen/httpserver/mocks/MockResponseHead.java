package javax.com.lallen.httpserver.mocks;

import javax.com.lallen.httpserver.core.response.iHeader;
import java.io.IOException;

/**
 * Created by latoyaallen on 2/17/15.
 */
public class MockResponseHead implements iHeader {
    private String STATUS = "";

    @Override
    public byte[] renderHead(int por, String status) throws IOException {
        STATUS += status;
        String constructedHead = "The head has been constructed.";
        return constructedHead.getBytes();
    }

    public String getSTATUS() {
        return STATUS;
    }
}
