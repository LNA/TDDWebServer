package javax.com.lallen.httpserver.cobspec.parsers;
import javax.com.lallen.httpserver.cobspec.constants.Args;

public class ArgsParser {

    public String getArgs(String[] args, String argType) {
        if (args.length == 0) {
            return defaultArgument(args, argType);
        } else {
            return args[1];
        }
    }

    private String defaultArgument(String[] args, String argType) {
        if (argType.equals(Args.PORT)) {
            return Args.DEFAULT_PORT;
        } else {
            return Args.DEFAULT_DIRECTORY;
        }
    }
}