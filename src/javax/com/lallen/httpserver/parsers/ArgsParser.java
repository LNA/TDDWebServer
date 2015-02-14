package javax.com.lallen.httpserver.parsers;

/**
 * Created by latoyaallen on 2/9/15.
 */
public class ArgsParser {
    public static final String DEFAULT_PORT = "5000";
    public static final String DEFAULT_DIRECTORY = "../cob_spec/public";
    public static final String PORT = "-p";

    public String getArgs(String[] args, String argType) {
        if (args.length == 0) {
            return defaultArgument(args, argType);
        } else {
            return args[1];
        }
    }

    private String defaultArgument(String[] args, String argType) {
        if (argType.equals(PORT)) {
            return DEFAULT_PORT;
        } else {
            return DEFAULT_DIRECTORY;
        }

    }
}
