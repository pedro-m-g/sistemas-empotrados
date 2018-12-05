package com.bsu.game.command;

import java.util.Map;
import java.util.HashMap;

public class CommandPalette {

    private final Map<String, Command> palette = new HashMap<>();
    private final Command nullCommand = new NullCommand();

    public CommandPalette setCommand(String name, Command command) {
        palette.put(name, command);
        return this;
    }

    public Command getCommand(String name) {
        return palette.getOrDefault(name, nullCommand);
    }

}