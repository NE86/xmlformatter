package com.example.xmlformatter.command;

import com.example.xmlformatter.model.PathHolder;

public interface Command {

    void execute(PathHolder pathHolder);

    String getName();

    String getTitle();
}
