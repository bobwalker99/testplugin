package uk.co.bobwalker.minecraft.plugins.fatduckplugin.command;

public enum Command {
    BURN,
    FLY;

    public static Command fromString(String value) {
        for (Command command : Command.values()) {
            if (command.toString().equalsIgnoreCase(value)) {
                return command;
            }
        }
        return null;
    }
}
