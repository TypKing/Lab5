/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

import java.util.HashMap;
import java.util.Scanner;

public abstract class Command {
    private String description;
    void execute(HashMap<String, Command> hashMap, Collection collection) {

    };
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
