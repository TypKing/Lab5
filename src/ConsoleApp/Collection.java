/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Collection {
    private LinkedHashSet<Worker> collection = new LinkedHashSet<>();
    private String type = getCollection().getClass().getTypeName();
    private LocalDateTime creationTime;
    private int countOfWorkers = 0;
    private Factory factory = new Factory();

    Collection() {
        setCreationTime(LocalDateTime.now());
    }

    public void add() {
        Worker worker = factory.createWorker();
        getCollection().add(worker);
        setCountOfWorkers(getCountOfWorkers() + 1);
    }
    public boolean addIfMax(){
        Worker worker = factory.createWorker();
        if(isMax(worker)){
            getCollection().add(worker);
            setCountOfWorkers(getCountOfWorkers()+1);
            return true;
        }else{
            return false;
        }
    }
    public boolean isMax(Worker worker) {
        boolean i = true;
        for (Worker worker1 : collection) {
            if (worker.compareTo(worker1) <= 0) {
                i = false;
                break;
            }
        }
        return i;
    }
    public void show() {
        if (!getCollection().isEmpty()) {
            int i = 1;
            for (Worker worker : collection) {
                System.out.println("Работник №" + i);
                System.out.println(worker.toString());
                i++;
            }
        } else {
            System.out.println("Коллекция пуста, у нее нет ни одного элемента!");
        }
    }

    public void replace(int id) {
        if (!getCollection().isEmpty()) {
            for (Worker worker : getCollection()) {
                if (worker.getId() == id) {
                    collection.remove(worker);
                    Worker newWorker = factory.createWorker();
                    newWorker.setId(id);
                    collection.add(newWorker);
                    System.out.println("Рабочий успешно обновлен!");
                    break;
                } else {
                    System.out.println("Работник с данным id не найден");
                    return;
                }
            }
        } else {
            System.out.println("Коллекция пуста!");
        }
    }

    public void remove(int id) {
        if (!getCollection().isEmpty()) {

            for (Worker worker : collection) {
                if (worker.getId() == id) {
                    IdGenerator.remove(worker.getId());
                    collection.remove(worker);
                    countOfWorkers--;
                    System.out.println("Рабочий успешно устранен");
                    return;
                }
            }
            System.out.println("Работник с данным id не найден");
        } else {
            System.out.println("Коллекция пуста!");
        }
    }
    public void clear(){
        collection.clear();
        IdGenerator.clear();
    }
    public String getInformation() {
        return Colors.green() + "Информация о коллекции:\n" + Colors.blue() + " Дата инициализации коллекции: " + Colors.reset() +
                getCreationTime() + Colors.blue() + "\n Тип коллекции: " + Colors.reset() + getType() + "\n " +
                Colors.blue() + "Количество элементов в коллекции: " + Colors.reset() + getCountOfWorkers();
    }

    public LinkedHashSet<Worker> getCollection() {
        return collection;
    }

    public void setCollection(LinkedHashSet<Worker> collection) {
        this.collection = collection;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreationTime() {
        return creationTime.toString();
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public int getCountOfWorkers() {
        return countOfWorkers;
    }

    public void setCountOfWorkers(int countOfWorkers) {
        this.countOfWorkers = countOfWorkers;
    }
}
