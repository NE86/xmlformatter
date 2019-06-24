package com.example.xmlformatter.command;

import com.example.xmlformatter.model.PathHolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class CommandInfo extends AbstractCommand implements Command {

    private static final String NAME = "info";

    public CommandInfo(String argument) {
        super(argument);
    }

    @Override
    public void execute(PathHolder pathHolder) {
        try (Stream<Path> paths = Files.find(pathHolder.getPath(), 1, (p, attr) -> attr.isDirectory())) {
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
