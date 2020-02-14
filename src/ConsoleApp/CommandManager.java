/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import ConsoleApp.Commands.Command;

import java.util.HashMap;

public class CommandManager {

    private final HashMap<String, Command> commandMap = new HashMap<>();
    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void execute(String commandName, HashMap<String, Command> commandMap, Collection collection, String... args) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("no command registered for " + commandName);
        }
            command.execute(commandMap, collection,args);

    }

    public HashMap<String, Command> getCommandMap() {
        return commandMap;
    }
}
