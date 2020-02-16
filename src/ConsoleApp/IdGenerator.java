/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.util.HashSet;

public class IdGenerator {
    private static Integer counter = 1;
    private static HashSet<Integer> idSet = new HashSet<Integer>();

    /**
     * Генерирует уникальный id
     * @return id
     */
    public static int generate() {
        while (idSet.contains(counter)) {
            if (counter == Integer.MAX_VALUE) {
                throw new OverflowException();
            }
            counter++;
        }
        push(counter);
        return counter;
    }

    public static HashSet<Integer> getIdSet() {
        return idSet;
    }

    /**
     * Добавляет все id в idSet
     * @param mySet множество id
     */
    public static void addAll(HashSet<Integer> mySet){
        idSet.addAll(mySet);
    }

    /**
     * Удаляет id из множества
     * @param id
     */
    public static void remove(Integer id) {
        idSet.remove(id);
        counter = Math.min(id,counter);
    }

    /**
     * очищает множество id
     */
    public  static void clear(){
        idSet.clear();
        counter = 1;
    }

    /**
     * Добавляет один id в множество
     * @param id
     */
    public static void push(Integer id) {
        idSet.add(id);
    }
}
