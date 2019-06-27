package com.example.xmlformatter.command;

import com.example.xmlformatter.factory.XmlElementActionFactory;
import com.example.xmlformatter.model.PathHolder;
import org.apache.logging.log4j.util.Strings;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ForkJoinPool;

public class CommandFormat extends AbstractCommand implements Command {

    private static final String NAME = "format";

    public CommandFormat(String argument) {
        super(argument);
    }

    @Override
    public void execute(PathHolder pathHolder) {
        String currentPath = pathHolder.getPath().toAbsolutePath().toString();
        if (Strings.isBlank(argument)) {
            System.out.println("Need name file");
        } else {
            currentPath += '\\' + argument;
            try {
                ForkJoinPool forkJoinPool = new ForkJoinPool();
                String content = new String(Files.readAllBytes(Paths.get(currentPath)), "UTF-8");
                Document doc = Jsoup.parse(content, "", Parser.xmlParser());
                forkJoinPool.submit(XmlElementActionFactory.getInstance(doc));
            } catch (IOException e) {
                System.out.println(e);
                System.out.println("File can't be read");
            }
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getTitle() {
        return "format xml file";
    }
}
