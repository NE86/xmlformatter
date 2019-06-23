package com.example.xmlformatter.utils;

public class CommandLinesUtils {

    public static String commandWord(String line) {
        if ((line = line.trim()).contains(" ")) {
            return line.substring(0, line.indexOf(" ")).trim();
        } else {
            return line;
        }
    }

    public static String commandArgs(String line) {
        if ((line = line.trim()).contains(" ")) {
            return line.substring(line.indexOf(" "), line.length() - line.indexOf(" ") + 2).trim();
        } else {
            return "";
        }

    }

}
