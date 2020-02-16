/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp.Commands;

import ConsoleApp.Collection;
import ConsoleApp.CommandManager;

import java.util.HashMap;

public abstract class Command {
    /**
     * Абсрактный класс Команды содержит в себе описание команды, ее аргументы и выполение
     */
    private String description;
    private String args = "";

    /**
     * Выполняет команду
     * @param hashMap Карта всех команд
     * @param collection коллекция для работы
     * @param mySwitch инвокер
     * @param arg аргументы
     */
    public void execute(HashMap<String, Command> hashMap, Collection collection, CommandManager mySwitch, String... arg) {

    };

    /**
     * @return Описание команды
     */
    public String getDescription() {
        return description;
    }

    /**
     * Изменяет аргументы
     * @param args аргументы команды
     */
    public void setArgs(String args) {
        this.args = args;
    }

    /**
     *
     * @return аргументы команды
     */
    public String getArgs() {
        return args;
    }

    /**
     * Изменяет описание команды
     * @param description новое описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
