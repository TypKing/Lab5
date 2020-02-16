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

public class AddIfMaxCommand extends Command {
    private final ConsoleCommands consoleCommands;

    public AddIfMaxCommand(ConsoleCommands consoleCommands) {
        setDescription("добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        if (arg.length > 0) throw new ArgException();
        else {
            consoleCommands.addIfMax(collection);
        }
    }
}
