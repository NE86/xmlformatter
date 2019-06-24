package com.example.xmlformatter.command;

import com.example.xmlformatter.model.PathHolder;

public class CommandExit extends AbstractCommand implements Command {

    private static final String NAME = "exit";

    public CommandExit(String argument) {
        super(null);
    }

    @Override
    public void execute(PathHolder pathHolder) {
        System.out.println("Exit!");
        System.exit(0);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getTitle() {
        return "exit program";
    }
}
