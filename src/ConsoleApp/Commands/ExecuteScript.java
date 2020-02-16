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

import java.io.File;
import java.util.HashMap;

public class ExecuteScript extends Command {
    private final ConsoleCommands consoleCommands;

    public ExecuteScript(ConsoleCommands consoleCommands) {
        setDescription("добавить новый элемент в коллекцию");
        setArgs(" file_name");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
        String path;
        String filePath = System.getenv("INPUT_PATH");
        if (filePath == null) {
            path = "src\\ConsoleApp\\resources\\";
        } else {
            path = filePath;
        }
        if (arg.length != 1) throw new ArgException();
        else {
            File file = new File(path+arg[0]);
            consoleCommands.executeScript(file,mySwitch,collection);
        }
    }
}
