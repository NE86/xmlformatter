package com.example.xmlformatter.factory;

import com.example.xmlformatter.command.Command;

@FunctionalInterface
public interface CommandFactory {
    Command getCommand(String argument);
}
