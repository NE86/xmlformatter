package com.example.xmlformatter.command;

import com.example.xmlformatter.service.ScannerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CommandInfo extends AbstractCommand implements Command {

    private static final String NAME = "info";

    public CommandInfo(ScannerService scannerService, String argument) {
        super(scannerService, argument);
    }

    @Override
    public void execute() {
        try (Stream<Path> paths = Files.find(scannerService.getPath(), 1,
            (path, attributes) -> attributes.isDirectory())) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            //path is valid
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getTitle() {
        return "all directories in the path";
    }
}
