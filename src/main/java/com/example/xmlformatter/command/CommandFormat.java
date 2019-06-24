package com.example.xmlformatter.command;

import com.example.xmlformatter.service.ScannerService;
import org.apache.logging.log4j.util.Strings;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class CommandFormat extends AbstractCommand implements Command {

    private static final String NAME = "format";

    public CommandFormat(ScannerService scannerService, String argument) {
        super(scannerService, argument);
    }

    @Override
    public void execute() {
        String currentPath = scannerService.getPath().toAbsolutePath().toString();
        if (Strings.isBlank(argument)) {
            System.out.println("need name file");
        } else {
            currentPath +=  '\\' + argument;

            XWPFDocument document = new XWPFDocument();

            //Write the Document in file system
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(new File(currentPath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            //create paragraph
            XWPFParagraph paragraph = document.createParagraph();

            //Set alignment paragraph to RIGHT
            paragraph.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun run = paragraph.createRun();
            run.setText("At tutorialspoint.com, we strive hard to " +
                "provide quality tutorials for self-learning " +
                "purpose in the domains of Academics, Information " +
                "Technology, Management and Computer Programming " +
                "Languages.");

            //Create Another paragraph
            paragraph = document.createParagraph();

            //Set alignment paragraph to CENTER
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            run = paragraph.createRun();
            run.setText("The endeavour started by Mohtashim, an AMU " +
                "alumni, who is the founder and the managing director " +
                "of Tutorials Point (I) Pvt. Ltd. He came up with the " +
                "website tutorialspoint.com in year 2006 with the help" +
                "of handpicked freelancers, with an array of tutorials" +
                " for computer programming languages. ");

            try {
                document.write(out);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
