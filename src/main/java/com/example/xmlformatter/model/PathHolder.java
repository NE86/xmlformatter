package com.example.xmlformatter.model;


import java.nio.file.Path;

public class PathHolder {

    private Path path;

    public PathHolder(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }
}
