public enum Commands {
    NULL_CMD("null"),
    LIST_ALL("list"),
    LIST_ALL_TITLES_AND_YEARS("listTitlesAndYears"),
    LIST_ALL_BY_GENRE("listByGenre"),
    SYNOPISIS_BY_ID("synopysis"),
    INFO_BY_ID("info"),
    UPDATE_QUANTITY("update"),
    QUANTITY_BY_ID("quantity");

    private String id;
    private static Commands[] cmds = Commands.values();

    Commands(String str) {
        this.id = str;
    }

    public String getName() {
        return id;
    }

    public static String fromEnum(Commands cmd) {
        return cmds[cmd.ordinal()].getName();
    }

    public static Commands fromString(String str) {
        for (Commands cmd : cmds) {
            if (cmd.getName().equals(str)) {
                return cmd;
            }
        }

        return NULL_CMD;
    }
}
