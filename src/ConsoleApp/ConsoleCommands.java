/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import ConsoleApp.Commands.Command;

import java.util.HashMap;
import java.util.Map;
public class ConsoleCommands {
    public void help(HashMap<String, Command> commandMap) {
        System.out.println(Colors.green() + "СПРАВКА" + Colors.reset());
        for (Map.Entry<String,Command> entry:commandMap.entrySet()) {
            System.out.println(Colors.blue() + entry.getKey() + entry.getValue().getArgs() + ": " + Colors.reset() + entry.getValue().getDescription());
        }
    }
    public void exit(){
        System.out.println("Пока");
    }
    public void add(Collection collection){
        collection.add();
    }
    public void info(Collection collection){
        System.out.println(collection.getInformation());
    }
    public void show(Collection collection){
        collection.show();
    }
    public void remove(Collection collection,int id){
        collection.remove(id);
    }
    public void update(Collection collection, int id){
        collection.replace(id);
    }
    public void clear(Collection collection){collection.clear();}
    public void addIfMax(Collection collection){
        if(collection.addIfMax()){
            System.out.println("Рабочий успешно добавлен");
        }else {
            System.out.println("Значение рабочего меньше максимального!");
        }
    }
}
