/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp.Commands;

import ConsoleApp.Collection;

import java.util.HashMap;

public abstract class Command {
    private String description;
    private String args = "";
    public void execute(HashMap<String, Command> hashMap, Collection collection, String... arg) {

    };
    public String getDescription() {
        return description;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getArgs() {
        return args;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
