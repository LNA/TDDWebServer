package javax.com.lallen.httpserver.mocks;

import javax.com.lallen.httpserver.core.response.iHeader;
import java.io.IOException;

/**
 * Created by latoyaallen on 2/17/15.
 */
public class MockHeadBuilder implements iHeader {
    private String STATUS = "";

    @Override
    public byte[] buildResponseHead(int por, String status) throws IOException {
        STATUS += status;
        String headBuilt = "The head has been constructed.";
        return headBuilt.getBytes();
    }

    public String getSTATUS() {
        return STATUS;
    }
}
