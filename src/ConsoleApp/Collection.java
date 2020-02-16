/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import com.google.gson.Gson;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Collection {
    private LinkedHashSet<Worker> collection = new LinkedHashSet<Worker>();
    private HashSet<String> passportSet = new HashSet<String>();
    private String type = getCollection().getClass().getTypeName();
    private LocalDateTime creationTime;
    private int countOfWorkers = 0;
    private Factory factory = new Factory();
    private File file;

    Collection(File file) {
        FileReader fileReader = new FileReader();
        this.file = file;
        try {
            LinkedHashSet<Worker> collection1 = fileReader.read(file);
            setCountOfWorkers(getCountOfWorkers() + collection1.size());
            collection.addAll(collection1);
            passportSet.addAll(fileReader.getPassportSet());
            IdGenerator.addAll(fileReader.getIdSet());
        }catch (FileException e){
            System.out.println(e.getMessage());
        }
        setCreationTime(LocalDateTime.now());
    }

    /**
     * Создает нового рабочего и добавляет его в коллекцию
     */
    public void add() {
        Worker worker = factory.createWorker();
        getCollection().add(worker);
        setCountOfWorkers(getCountOfWorkers() + 1);
    }

    /**
     * Создает рабочего и добавляет его в коллекцию если его значение максимально
     * @return возвращает true если получилось добавить и false если нет
     */
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

    /**
     * Проверяет рабочего на максимальность в коллекции
     * @param worker рабочий для сравнения
     * @return true если максимален и false если нет
     */
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

    /**
     * Выводит построчно все элементы коллекции
     */
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

    /**
     * Заменяет элемент коллекции по его id
     * @param id заданный id
     */
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

    /**
     * Удаляет элемент коллекции с заданным id
     * @param id заданный id
     */
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

    /**
     * Удаляет все элементы коллекции превыщающие заданный
     */
    public void removeGreater(){
        Worker newWorker = factory.createWorker();
        LinkedHashSet<Worker> collection1 = new LinkedHashSet<>();
        IdGenerator.clear();
        countOfWorkers = 0;
        collection.forEach(worker -> {
            if(newWorker.compareTo(worker)>=0){
                collection1.add(worker);
                countOfWorkers++;
                IdGenerator.push(worker.getId());
            }
        });
        collection = collection1;
    }
    /**
     * Удаляет все элементы коллекции меньшие чем заданный
     */
    public void removeLower(){
        Worker newWorker = factory.createWorker();
        LinkedHashSet<Worker> collection1 = new LinkedHashSet<>();
        IdGenerator.clear();
        countOfWorkers = 0;
        collection.forEach(worker -> {
            if(newWorker.compareTo(worker)<=0){
                collection1.add(worker);
                countOfWorkers++;
                IdGenerator.push(worker.getId());
            }
        });
        collection = collection1;
    }

    /**
     * Очищает коллекцию
     */
    public void clear(){
        countOfWorkers -= collection.size();
        collection.clear();
        IdGenerator.clear();
    }

    /**
     * Выводит информацию о коллекции
     * @return строка информации
     */
    public String getInformation() {
        return Colors.green() + "Информация о коллекции:\n" + Colors.blue() + " Дата инициализации коллекции: " + Colors.reset() +
                getCreationTime() + Colors.blue() + "\n Тип коллекции: " + Colors.reset() + getType() + "\n " +
                Colors.blue() + "Количество элементов в коллекции: " + Colors.reset() + getCountOfWorkers();
    }

    /**
     * Подсчитывает количество элементов коллекции с salary больше заданной
     * @param salary1 заданная зарплата
     * @return количество элементов
     */
    public long countGreaterThanSalary(double salary1){
        return collection.stream().filter(worker -> worker.getSalary() > salary1).count();
    }

    /**
     * @return возвращает коллекцию
     */
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

    /**
     * Сохраняет коллекцию
     */
    public void save(){
        try {
            FileWriter writer1 = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(writer1);
            writer.write("[\n");
            int i = 0;
            for(Iterator<Worker> iterator = collection.iterator();iterator.hasNext();){
                i++;
                writer.write(iterator.next().toJSON());
                if(i<collection.size()){
                    writer.write(",");
                }
                writer.write("\n");
            }
            writer.write("]\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Не получилось записать файл");
            e.printStackTrace();
        }
    }

    /**
     * изменяет число рабочих
     * @param countOfWorkers количество рабочих
     */
    public void setCountOfWorkers(int countOfWorkers) {
        this.countOfWorkers = countOfWorkers;
    }
}
