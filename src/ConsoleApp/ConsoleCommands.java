/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import ConsoleApp.Commands.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Receiver
 * Обеспечивает выполнение комманд
 */
public class ConsoleCommands {
    public void help(HashMap<String, Command> commandMap) {
        System.out.println(Colors.green() + "СПРАВКА" + Colors.reset());
        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            System.out.println(Colors.blue() + entry.getKey() + entry.getValue().getArgs() + ": " + Colors.reset() + entry.getValue().getDescription());
        }
    }

    /**
     * Выполняет выход их консоли
     */
    public void exit() {
        System.out.println("Пока");
    }

    /**
     * Добавляет элемент в коллекцию
     * @param collection сама коллекция
     */
    public void add(Collection collection) {
        collection.add();
    }

    /**
     * Выводит информацию о коллекции
     * @param collection сама коллекция
     */
    public void info(Collection collection) {
        System.out.println(collection.getInformation());
    }

    /**
     * Построчно выводит все элементы коллекции
     * @param collection коллекция которую необходимо выводить
     */
    public void show(Collection collection) {
        collection.show();
    }

    /**
     * Удаляет из коллекции элемент id которого равен заданному
     * @param collection коллекция
     * @param id заданный id
     */
    public void remove(Collection collection, int id) {
        collection.remove(id);
    }

    /**
     * Заменяет элемент коллекции элемент id которого равен заданному
     * @param collection коллекция
     * @param id заданный id
     */
    public void update(Collection collection, int id) {
        collection.replace(id);
    }

    /**
     * Очищает коллекцию
     * @param collection коллекция
     */
    public void clear(Collection collection) {
        collection.clear();
    }

    /**
     * Добавляет новый элемент в коллекцию если его значение выше максимального
     * @param collection коллекция
     */
    public void addIfMax(Collection collection) {
        if (collection.addIfMax()) {
            System.out.println("Рабочий успешно добавлен");
        } else {
            System.out.println("Значение рабочего меньше максимального!");
        }
    }

    /**
     * Удаляет все элементы коллекции превышающий заданный
     * @param collection коллекция
     */
    public void removeGreater(Collection collection) {
        collection.removeGreater();
    }
    /**
     * Удаляет все элементы коллекции меньше заданного
     * @param collection коллекция
     */
    public void removeLower(Collection collection) {
        collection.removeLower();
    }

    /**
     * Подсчитывает количество элементов коллекции с salary больше заданного
     * @param collection коллекция
     * @param arg заданная зарплата
     */
    public void countGreaterThanSalary(Collection collection, String arg) {
        try {
            double salary = Double.parseDouble(arg);
            System.out.println("На данный момент мы имеем " + collection.countGreaterThanSalary(salary) + " рабочих чья " +
                    "зарплата выше " + salary + " рублей.");
        } catch (NumberFormatException e) {
            throw new ArgException();
        }
    }

    /**
     * Сохраняет коллекцию в файл
     * @param collection коллекция
     */
    public void save(Collection collection) {
        collection.save();
        System.out.println("Коллекция успешно сохранена");
    }

    /**
     * Выводит значения поля Person по возрастанию
     */
    public void printFieldAscendingPerson() {
        Factory factory = new Factory();
        Person person = factory.createPerson();
        person.printAscendingValues();
    }

    /**
     * Выполняет скрипт
     * @param file исполняемый файл
     * @param mySwitch наш Инвокер
     * @param myCollection коллекция
     */
    public void executeScript(File file,CommandManager mySwitch,Collection myCollection) {
        try {
            Scanner scanner = new Scanner(file);
            String line = "";
            while (!line.equals("exit") && scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] lines = line.split(" ");
                try {
                    String command = lines[0];

                    if (lines.length > 1) {
                        String arg = lines[1];
                        try {
                            mySwitch.execute(command, mySwitch.getCommandMap(), myCollection, arg);
                        } catch (IllegalStateException e) {
                            System.out.println("Вы ввели неправильную команду, попробуйте снова!");
                        } catch (ArgException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            mySwitch.execute(command, mySwitch.getCommandMap(), myCollection);
                        } catch (IllegalStateException e) {
                            System.out.println("Вы ввели неправильную команду, попробуйте снова!");
                        } catch (ArgException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Вы ввели непрвильную команду, попробуйте снова");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Скрипт не найден.");
        }
    }
}
