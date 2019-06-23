package com.example.xmlformatter.command;

import com.example.xmlformatter.service.ScannerService;

abstract class AbstractCommand {
    ScannerService scannerService;

    String argument;

    private AbstractCommand() {
    }

    AbstractCommand(ScannerService scannerService, String argument) {
        this.scannerService = scannerService;
        this.argument = argument;
    }
}
