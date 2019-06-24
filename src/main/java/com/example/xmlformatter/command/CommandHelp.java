package com.example.xmlformatter.command;

import com.example.xmlformatter.factory.AbstractCommandFactory;
import com.example.xmlformatter.model.PathHolder;

import java.util.Arrays;

public class CommandHelp extends AbstractCommand implements Command {

    private static final String NAME = "help";

    public CommandHelp(String argument) {
        super(null);
    }

    @Override
    public void execute(PathHolder pathHolder) {
        Arrays.asList(AbstractCommandFactory.CommandList.values()).forEach(x -> {
            Command command = x.getCommandFactory().getCommand(null);
            System.out.println(command.getName() + " - " + command.getTitle());
        });
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getTitle() {
        return "view all command";
    }
}
