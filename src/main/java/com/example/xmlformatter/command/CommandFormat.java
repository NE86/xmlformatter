package com.example.xmlformatter.command;

import com.example.xmlformatter.formatter.DateFormatter;
import com.example.xmlformatter.model.PathHolder;
import org.apache.logging.log4j.util.Strings;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CommandFormat extends AbstractCommand implements Command {

    private static final String NAME = "format";

    public CommandFormat(String argument) {
        super(argument);
    }

    @Override
    public void execute(PathHolder pathHolder) {
        String currentPath = pathHolder.getPath().toAbsolutePath().toString();
        if (Strings.isBlank(argument)) {
            System.out.println("need name file");
        } else {
            currentPath += '\\' + argument;
            try {
                String content = new String(Files.readAllBytes(Paths.get(currentPath)), "UTF-8");
                Document doc = Jsoup.parse(content, "",  Parser.xmlParser());
                new DateFormatter(doc).child(doc.children().get(0));
                //Jsoup.parse(content, "",  Parser.xmlParser()).getAllElements().get(0).childElementsList().get(0).childElementsList()
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Files.readAllBytes(Paths.get(currentPath))
            System.out.println("alignparagraph.docx written successfully");
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
