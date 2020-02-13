/*
 * Copyright (c) 2020. Ivannikov Alexandr Romanovich.
 * The text of this program is protected by copyright. Using it for commercial or personal purposes is prohibited
 * All rights reserved.
 */

package ConsoleApp;

public class Colors {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static String reset(){
        return ANSI_RESET;
    }
    public static String black(){
        return ANSI_BLACK;
    }
    public static String red(){
        return ANSI_RED;
    }
    public static String green(){
        return ANSI_GREEN;
    }
    public static String yellow(){
        return ANSI_YELLOW;
    }
    public static String blue(){
        return ANSI_BLUE;
    }
    public static String purple(){
        return ANSI_PURPLE;
    }
    public static String cyan(){
        return ANSI_CYAN;
    }
    public static String white(){
        return ANSI_WHITE;
    }
}
