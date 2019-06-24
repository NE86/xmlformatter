package com.example.xmlformatter.command;

abstract class AbstractCommand {
    protected String argument;

    AbstractCommand(String argument) {
        this.argument = argument;
    }
}
