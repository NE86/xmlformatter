package com.example.xmlformatter.service;

import com.example.xmlformatter.factory.AbstractCommandFactory;
import com.example.xmlformatter.model.PathHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ScannerService {

    private final Scanner scanner;

    private PathHolder pathHolder;

    @Autowired
    public ScannerService(Scanner scanner, PathHolder pathHolder) {
        this.scanner = scanner;
        this.pathHolder = pathHolder;
    }

    public void run() {
        System.out.print("Enter something : ");
        String input = scanner.nextLine();

        AbstractCommandFactory.getCommand(input).execute(pathHolder);

        System.out.println("-----------\n");
        run();
    }
}
