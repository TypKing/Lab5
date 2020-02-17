/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp.Commands;

import ConsoleApp.ArgException;
import ConsoleApp.Collection;
import ConsoleApp.CommandManager;
import ConsoleApp.ConsoleCommands;

import java.util.HashMap;

public class FilterCommand extends Command {
    private final ConsoleCommands consoleCommands;

    public FilterCommand(ConsoleCommands consoleCommands) {
        setDescription("вывести элементы, значение поля name которых содержит заданную подстроку");
        setArgs(" name");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        if (arg.length != 1) throw new ArgException();
        else {
            consoleCommands.filterName(collection,arg[0]);
        }
    }
}
