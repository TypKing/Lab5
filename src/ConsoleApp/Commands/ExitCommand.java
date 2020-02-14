/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp.Commands;

import ConsoleApp.Collection;
import ConsoleApp.Commands.Command;
import ConsoleApp.ConsoleCommands;

import java.util.HashMap;

public class ExitCommand extends Command {
        private final ConsoleCommands consoleCommands;

        public ExitCommand(ConsoleCommands consoleCommands){
            setDescription("завершить программу (без сохранения в файл)");
            this.consoleCommands = consoleCommands;
        }

        @Override
        public void execute(HashMap<String, Command> commandMap, Collection collection, String... arg) {
            consoleCommands.exit();
        }
    }

