package com.example.xmlformatter.command;

import com.example.xmlformatter.factory.AbstractCommandFactory;
import com.example.xmlformatter.service.ScannerService;

import java.util.Arrays;

public class CommandHelp extends AbstractCommand implements Command {

    private static final String NAME = "help";

    public CommandHelp(ScannerService scannerService, String argument) {
        super(scannerService, null);
    }

    @Override
    public void execute() {
        Arrays.asList(AbstractCommandFactory.CommandList.values()).forEach(x -> {
            Command command = x.getCommandFactory().getCommand(scannerService, null);
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
