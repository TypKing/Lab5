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


    public static void remove(Integer id) {
        idSet.remove(id);
        counter = Math.min(id,counter);
    }
    public  static void clear(){
        idSet.clear();
        counter = 1;
    }
    public static void push(Integer id) {
        idSet.add(id);
    }
}
