package com.example.xmlformatter.factory.command;

import com.example.xmlformatter.command.Command;
import com.example.xmlformatter.service.ScannerService;

public interface CommandFactory {
     Command getCommand(ScannerService scannerService, String argument);
}
