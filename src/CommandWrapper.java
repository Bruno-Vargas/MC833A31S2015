public class CommandWrapper {
    public Commands command;
    public String identifier;
    public int quantity;

    public CommandWrapper(Commands cmd, String identifier, int quantity) {
        this.command = cmd;
        this.identifier = identifier;
        this.quantity = quantity;
    }

    public CommandWrapper(Commands cmd, String identifier) {
        this(cmd, identifier, 0);
    }

    public CommandWrapper(Commands cmd) {
        this(cmd, "", 0);
    }

    public String toString() {
        return this.command + " " + this.identifier +  " " + this.quantity;
    }
}
