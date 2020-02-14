/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp.Commands;

import ConsoleApp.ArgException;
import ConsoleApp.Collection;
import ConsoleApp.ConsoleCommands;

import java.util.HashMap;

public class ClearCommand extends Command {
    private final ConsoleCommands consoleCommands;

    public ClearCommand(ConsoleCommands consoleCommands) {
        setDescription("очистить коллекцию");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, String... arg) {
        if (arg.length > 0) throw new ArgException();
        else {
            consoleCommands.clear(collection);
        }
    }
}
