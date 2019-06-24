package com.example.xmlformatter.command;

import com.example.xmlformatter.service.ScannerService;

public class CommandNotFound extends AbstractCommand implements Command {

    public CommandNotFound(ScannerService scannerService, String argument) {
        super(scannerService, null);
    }

    @Override
    public void execute() {
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
