/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        ConsoleCommands consoleCommands = new ConsoleCommands();
        Collection myCollection = new Collection();
        Command help = new HelpCommand(consoleCommands);
        Command info = new InfoCommand(consoleCommands);
        Command exit = new ExitCommand(consoleCommands);
        Command add = new AddCommand(consoleCommands);
        Command show = new ShowCommand(consoleCommands);
        CommandManager mySwitch = new CommandManager();
        mySwitch.register("help", help);
        mySwitch.register("info", info);
        mySwitch.register("exit", exit);
        mySwitch.register("add", add);
        mySwitch.register("show", show);
        while (!line.equals("exit")) {
            line = scanner.nextLine();
            try {
                mySwitch.execute(line, mySwitch.getCommandMap(),myCollection);
            }catch (IllegalStateException e){
                System.out.println("Вы ввели неправильную команду, попробуйте снова!");
            }

        }
        scanner.close();
    }
}

/*
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

System.out.println(ANSI_PURPLE + "Список комманд:" + ANSI_RESET + " ");
        System.out.println(ANSI_RED + "help:" + ANSI_RESET + " вывести справку по доступным командам");
        System.out.println(ANSI_RED + "info:" + ANSI_RESET + " вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println(ANSI_RED + "show:" + ANSI_RESET + " вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println(ANSI_RED + "add {element}:" + ANSI_RESET + " добавить новый элемент в коллекцию");
        System.out.println(ANSI_RED + "update if {element}:" + ANSI_RESET + " обновить значение элемента коллекции, id которого равен заданному");
        System.out.println(ANSI_RED + "remove_by_id id:" + ANSI_RESET + " удалить элемент из коллекции по его id");
        System.out.println(ANSI_RED + "clear:" + ANSI_RESET + " очистить коллекцию");
        System.out.println(ANSI_RED + "save:" + ANSI_RESET + " сохранить коллекцию в файл");
        System.out.println(ANSI_RED + "execute_script file_name:" + ANSI_RESET + " считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println(ANSI_RED + "exit:" + ANSI_RESET + " завершить программу (без сохранения в файл)");
        System.out.println(ANSI_RED + "remove_first:" + ANSI_RESET + " удалить первый элемент из коллекции");
        System.out.println(ANSI_RED + "add_if_max {element}:" + ANSI_RESET + " добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        System.out.println(ANSI_RED + "history:" + ANSI_RESET + " вывести последние 12 команд (без их аргументов)");
        System.out.println(ANSI_RED + "min_by_id:" + ANSI_RESET + " вывести любой объект из коллекции, значение поля id которого является минимальным");
        System.out.println(ANSI_RED + "filter_by_salary salary:" + ANSI_RESET + " вывести элементы, значение поля salary которых равно заданному");
        System.out.println(ANSI_RED + "print_field_descending_person person:" + ANSI_RESET + " вывести значения поля person в порядке убывания ");
 */