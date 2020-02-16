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

public class CountGreaterThanSalary extends Command {
    private final ConsoleCommands consoleCommands;

    public CountGreaterThanSalary(ConsoleCommands consoleCommands) {
        setDescription("вывести элементы, значение поля name которых больше заданного");
        setArgs(" salary");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        if (arg.length != 1) throw new ArgException();
        else {
            consoleCommands.countGreaterThanSalary(collection,arg[0]);
        }
    }
}
