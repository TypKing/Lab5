/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.util.HashMap;
import java.util.Map;
public class ConsoleCommands {
    public void help(HashMap<String, Command> commandMap) {
        System.out.println(Colors.green() + "СПРАВКА" + Colors.reset());
        for (Map.Entry<String,Command> entry:commandMap.entrySet()) {
            System.out.println(Colors.blue() + entry.getKey() + ": " + Colors.reset() + entry.getValue().getDescription());
        }

    }
    Factory factory = new Factory();
    public void exit(){
        System.out.println("Пока");
    }
    public void add(Collection collection){
        collection.add(factory.createWorker());
    }
    public void info(Collection collection){
        System.out.println(collection.getInformation());
    }
    public void show(Collection collection){
        if(!collection.getCollection().isEmpty()) {
            int i = 1;
            for (Worker worker : collection.getCollection()) {
                System.out.println("Работник №"+i);
                System.out.println(worker.toString());
                i++;
            }
        }
        else{
            System.out.println("Коллекция пуста, у нее нет ни одного элемента!");
        }
    }
}
