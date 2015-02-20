package javax.com.lallen.httpserver.mocks;

import javax.com.lallen.httpserver.response.iHeader;
import java.io.IOException;

/**
 * Created by latoyaallen on 2/17/15.
 */
public class MockHeadBuilder implements iHeader {

    @Override
    public byte[] buildResponseHead(int por, String status) throws IOException {
        String headBuilt = "The head has been constructed.";
        return headBuilt.getBytes();
    }
}
