/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;

public class Collection {
    private LinkedHashSet<Worker> collection = new LinkedHashSet<>();
    private String type = getCollection().getClass().getTypeName();
    private LocalDateTime creationTime;
    private int countOfWorkers = 0;

    Collection() {
        setCreationTime(LocalDateTime.now());
    }

    public void add(Worker worker) {
        getCollection().add(worker);
        setCountOfWorkers(getCountOfWorkers() + 1);
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
