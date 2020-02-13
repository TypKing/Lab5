/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.util.HashMap;

public class InfoCommand extends Command{
    private final ConsoleCommands consoleCommands;

    public InfoCommand(ConsoleCommands consoleCommands){
        setDescription("вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        this.consoleCommands = consoleCommands;
    }

    @Override
    public void execute(HashMap<String, Command> commandMap, Collection collection) {
        consoleCommands.info(collection);
    }
}
