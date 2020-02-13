/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.util.HashMap;
import java.util.Scanner;

public class AddCommand extends Command{
    private final ConsoleCommands consoleCommands;

    public AddCommand(ConsoleCommands consoleCommands){
        setDescription("добавить новый элемент в коллекцию");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection) {
        consoleCommands.add(collection);
    }
}
