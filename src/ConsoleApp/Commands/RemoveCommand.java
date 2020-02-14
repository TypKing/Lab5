/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp.Commands;

import ConsoleApp.ArgException;
import ConsoleApp.Collection;
import ConsoleApp.Commands.Command;
import ConsoleApp.ConsoleCommands;

import java.util.HashMap;

public class RemoveCommand extends Command {
    private final ConsoleCommands consoleCommands;

    public RemoveCommand(ConsoleCommands consoleCommands){
        setDescription("удалить элемент из коллекции по его id");
        setArgs(" id");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, String... arg) {
        try {
            consoleCommands.remove(collection, Integer.parseInt(arg[0]));
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new ArgException();
        }
    }
}
