package com.example.xmlformatter.factory;

import com.example.xmlformatter.command.Command;
import com.example.xmlformatter.command.CommandCD;
import com.example.xmlformatter.command.CommandExit;
import com.example.xmlformatter.command.CommandFile;
import com.example.xmlformatter.command.CommandFormat;
import com.example.xmlformatter.command.CommandHelp;
import com.example.xmlformatter.command.CommandInfo;
import com.example.xmlformatter.command.CommandNotFound;
import com.example.xmlformatter.utils.CommandLinesUtils;

public class AbstractCommandFactory {

    public static Command getCommand(String commandLine) {
        CommandList commandList;
        try {
            commandList = CommandList.valueOf(CommandLinesUtils.commandWord(commandLine).toUpperCase());
        } catch (final IllegalArgumentException e) {
            commandList = CommandList.NOT_FOUND;
        }
        return commandList.getCommandFactory().getCommand(CommandLinesUtils.commandArgs(commandLine));
    }

    public enum CommandList {
        CD(CommandCD::new),
        HELP(CommandHelp::new),
        INFO(CommandInfo::new),
        FILE(CommandFile::new),
        FORMAT(CommandFormat::new),
        EXIT(CommandExit::new),
        NOT_FOUND(CommandNotFound::new);

        private CommandFactory command;

        CommandList(CommandFactory command) {
            this.command = command;
        }

        public CommandFactory getCommandFactory() {
            return command;
        }
    }

}
