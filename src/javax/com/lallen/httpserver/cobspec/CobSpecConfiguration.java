package javax.com.lallen.httpserver.cobspec;
import javax.com.lallen.httpserver.cobspec.parsers.ArgsParser;
import javax.com.lallen.httpserver.core.ServerConfiguration;

public class CobSpecConfiguration implements ServerConfiguration {
    public static final String PORT = "-p";
    public static final String DIRECTORY = "-d";
    private final String[] args;
    private final ArgsParser argsParser;

    public CobSpecConfiguration(String[] args, ArgsParser argsParser) {
        this.args = args;
        this.argsParser = argsParser;
    }

    @Override
    public int port() {
        String port = argsParser.getArgs(args, PORT);
        return Integer.parseInt(port);
    }

    @Override
    public String directory() {
        return argsParser.getArgs(args, DIRECTORY);
    }

//    @Override
//        public Router router() {
//            return new RouterBuilder()
//                    .addRoute("GET", "/search", new SearchHandler())
//                    .addRoute("GET", "/v2/search", new SearchHandler())
//
//                    .addRoute("GET", "/file.jpg", new FileHandler()) //tedious - belongs in "core" HTTP server
//                    .addRoute("GET", "/file2.png", new FileHandler()) //tedious - belongs in "core" HTTP server
//                    .addRoute("GET", "/foobar", new EmptyResponse())
//                    //.addRoute("GET", "/", new )
//                    .build();
//        }
//
//        private class RouterBuilder {
}
