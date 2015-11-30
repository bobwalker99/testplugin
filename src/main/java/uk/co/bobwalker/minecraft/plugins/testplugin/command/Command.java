package uk.co.bobwalker.minecraft.plugins.testplugin.command;

public enum Command {
    BURN;

    public static Command fromString(String value) {
        for (Command command : Command.values()) {
            if (command.toString().equalsIgnoreCase(value)) {
                return command;
            }
        }
        return null;
    }
}
