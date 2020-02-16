/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

public class FileArgsException extends RuntimeException{
    public FileArgsException(){
        super("Объекты хранимые в файле содержат недопустимые Аргументы!");
    }
}
