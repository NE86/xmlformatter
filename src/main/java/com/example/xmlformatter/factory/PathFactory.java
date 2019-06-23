package com.example.xmlformatter.factory;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathFactory {

    private static Path instance;

    private PathFactory() {
    }

    public static synchronized Path getInstance() {
        if (instance == null) {
            instance = FileSystems.getDefault().getRootDirectories().iterator().next();
        }
        return instance;
    }
}
