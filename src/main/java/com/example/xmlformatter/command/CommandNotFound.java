package com.example.xmlformatter.command;

import com.example.xmlformatter.model.PathHolder;

public class CommandNotFound extends AbstractCommand implements Command {

    public CommandNotFound(String argument) {
        super(null);
    }

    @Override
    public void execute(PathHolder pathHolder) {
        System.out.println("Command not found");
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getTitle() {
        return "command not found";
    }
}
