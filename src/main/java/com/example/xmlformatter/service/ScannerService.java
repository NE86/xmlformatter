package com.example.xmlformatter.service;

import com.example.xmlformatter.factory.AbstractCommandFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Scanner;

@Service
public class ScannerService {

    private final Scanner scanner;

    private Path path;

    private boolean stop = false;

    @Autowired
    public ScannerService(Scanner scanner, Path path) {
        this.scanner = scanner;
        this.path = path;
    }

    public void run() {
        System.out.print("Enter something : ");
        String input = scanner.nextLine();

        AbstractCommandFactory.getCommand(input, this).execute();

        System.out.println("-----------\n");
        if (!stop) {
            run();
        }
    }

    public void shutdown() {
        stop = true;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
