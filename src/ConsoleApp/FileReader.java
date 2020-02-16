/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FileReader {
    HashSet<String> passportSet = new HashSet<String>();
    HashSet<Integer> idSet = new HashSet<Integer>();
    public FileReader(){
    }

    /**
     * Считывает Коллекцию workers из файла file
     * @param file файл из которого считываются данные
     * @return коллекция workers
     */
    public LinkedHashSet<Worker> read(File file){

        LinkedHashSet<Worker> workers = new LinkedHashSet<Worker>();
        try {
            Scanner scanner = new Scanner(file);
            String line;
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                if(line.equals("[") || line.equals("]")) {
                }
                else{
                    if(line.charAt(line.length()-1) == ',') {
                        line = line.substring(0, line.length() - 1);
                    }
                    Worker worker = Worker.parseWorker(line);
                    if (worker.getPerson() != null && worker.getPerson().getPassportID() != null && passportSet.contains(worker.getPerson().getPassportID())) {
                        throw new FileArgsException();
                    } else if (idSet.contains(worker.getId())) {
                        throw new FileArgsException();
                    } else {
                        workers.add(worker);
                        if (worker.getPerson() != null && worker.getPerson().getPassportID() != null) {
                            passportSet.add(worker.getPerson().getPassportID());
                        }
                        idSet.add(worker.getId());
                    }
                }
            }
            return workers;
        } catch (IOException e) {
            throw new FileException("Мы не смогли обработать файл, исправьте ошибки связанные с ним");
        } catch (JsonSyntaxException e){
            throw new FileException("Файл содержит синтаксические ошибки, исправьте синтаксис и перезапустите программу");
        } catch (FileArgsException e){
            throw new FileException("Файл содержит невозможные данные");
        }
    }

    public HashSet<Integer> getIdSet() {
        return idSet;
    }

    public HashSet<String> getPassportSet() {
        return passportSet;
    }
}
