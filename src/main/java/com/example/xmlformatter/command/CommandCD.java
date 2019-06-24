package com.example.xmlformatter.command;

import com.example.xmlformatter.service.ScannerService;
import org.apache.logging.log4j.util.Strings;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandCD extends AbstractCommand implements Command {

    private static final String NAME = "cd";

    public CommandCD(ScannerService scannerService, String argument) {
        super(scannerService, argument);
    }

    @Override
    public void execute() {
        String currentPath = scannerService.getPath().toAbsolutePath().toString();
        Path newPath;
        if (Strings.isBlank(argument)) {
            newPath = down(currentPath);
        } else {
            newPath = up(currentPath);
        }
        if (Files.exists(newPath)) {
            scannerService.setPath(newPath);
            System.out.println(newPath.toAbsolutePath().toString());
        } else {
            System.out.println("Path not found!");
        }
    }

    private Path up(final String currentPath) {
        return Paths.get(currentPath + '\\' + argument);
    }

    private Path down(String currentPath) {
        int index = currentPath.lastIndexOf("\\");
        return Paths.get(currentPath.substring(0, index + 1));
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getTitle() {
        return "move directory";
    }


}
