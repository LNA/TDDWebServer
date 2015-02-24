package javax.com.lallen.httpserver.cobspec.parsers;

import org.junit.Test;

import javax.com.lallen.httpserver.cobspec.parsers.ArgsParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by latoyaallen on 2/9/15.
 */
public class ArgsParserTest {


    @Test
    public void itHasADefaultPort() {
        String[] args = {};
        ArgsParser portParser = new ArgsParser();
        String port = portParser.getArgs(args, "-p");
        assertEquals("5000", port);
    }

    @Test
    public void itGetsAPort() {
        String[] args = {"-p", "9021"};
        ArgsParser parser = new ArgsParser();
        assertEquals("9021", parser.getArgs(args, "-p"));
    }


    @Test
    public void testGetDefaultDirectory() {
        String[] args = {};
        ArgsParser parser = new ArgsParser();
        assertEquals("../cob_spec/public", parser.getArgs(args, "-d"));
    }

    @Test
    public void testGetAssignedDirectory() {
        String[] args = {"-d", "/rose/water"};
        ArgsParser parser = new ArgsParser();
        assertEquals("/rose/water", parser.getArgs(args, "-d"));
    }
}
