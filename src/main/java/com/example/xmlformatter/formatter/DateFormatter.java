package com.example.xmlformatter.formatter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;

public class DateFormatter {

    Document doc;

    public DateFormatter(Document doc) {
        this.doc = doc;
    }

    public void rec(){
        Elements allElements = doc.getAllElements();
        Element element = allElements.get(0);
    }

    public void child(Element element) {
        Elements children = element.children();
        if ("w:r".equals(element.tagName()) && element.attributes().size()!=0){
            System.out.println(element.toString());
        }
        if (children.isEmpty()){
            String text = element.text();
            if (text.contains("N") || text.contains("2019")){
                System.out.println(text);
            }
        } else {
            for (Element element1:children) {
                child(element1);
            }
        }

    }

}
