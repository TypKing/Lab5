/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.util.HashMap;

public class HelpCommand extends Command{
    private final ConsoleCommands consoleCommands;

    public HelpCommand(ConsoleCommands consoleCommands){
        setDescription("вывести справку по доступным командам");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection) {
        consoleCommands.help(commandMap);
    }
}
