package com.example.xmlformatter.factory;

import java.util.Scanner;

public class ScannerFactory {

    private static Scanner instance;

    private ScannerFactory() {
    }

    public static synchronized Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner(System.in);
        }
        return instance;
    }

}
