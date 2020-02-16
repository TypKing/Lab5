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

public class UpdateCommand extends Command {
    private final ConsoleCommands consoleCommands;

    public UpdateCommand(ConsoleCommands consoleCommands) {
        setDescription("обновить значение элемента коллекции, id которого равен заданному");
        setArgs(" id");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        try {
            consoleCommands.update(collection,Integer.parseInt(arg[0]));
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new ArgException();
        }

    }
}
