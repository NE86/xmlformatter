package com.example.xmlformatter.command;

import com.example.xmlformatter.service.ScannerService;

public class CommandExit extends AbstractCommand implements Command {

    private static final String NAME = "exit";

    public CommandExit(ScannerService scannerService, String argument) {
        super(scannerService, null);
    }

    @Override
    public void execute() {
        doExit();
        scannerService.getScanner().close();
        scannerService.shutdown();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getTitle() {
        return "exit program";
    }

    private void doExit() {
        System.out.println("Exit!");
    }
}
