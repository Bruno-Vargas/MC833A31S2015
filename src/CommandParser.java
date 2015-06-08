import java.lang.Exception;
public class CommandParser {

    public CommandWrapper parseCommand(String args[]) {
        if (args.length == 0 || args.length > 3) {
            return new CommandWrapper(Commands.NULL_CMD);
        }

        // Validate cmd
        Commands parsedCmd = Commands.fromString(args[0]);

        switch (parsedCmd) {
            case NULL_CMD:
            case LIST_ALL:
            case LIST_ALL_TITLES_AND_YEARS:
                return new CommandWrapper(parsedCmd);
            case LIST_ALL_BY_GENRE:
            case SYNOPISIS_BY_ID:
            case INFO_BY_ID:
            case QUANTITY_BY_ID:
                return new CommandWrapper(parsedCmd, args[1]);
            case UPDATE_QUANTITY:
                return new CommandWrapper(parsedCmd, args[1], Integer.valueOf(args[2]));

        }

        return null;
    }
}
