package com.example.xmlformatter.formatter;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Pattern;


public class XmlModifyUtils {

    public Element replaceDocumentNumber(Element element) {
        final String regEx = "N\\s([^\\s]*)";
        final String replace = "document_number";
        return replaceDocumentValue(element, regEx, replace);
    }

    public Element replaceDocumentDate(Element element) {
        final String regEx = "(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d";
        final String replace = "document_date";
        return replaceDocumentValue(element, regEx, replace);
    }

    public Element deleteRsid(Element element) {
        if ("w:r".equals(element.tagName())) {
            Attributes attributes;
            if ((attributes = element.attributes()).hasKey("w:rsid")) {
                attributes.remove("w:rsid");
            }
        }
        return element;
    }

    public Element combineWR(Element element) {
        Elements wr = element.children().tagName("w:r");
        if (wr.size() > 1) {
            Element elementBuffer = wr.first();
            for (Element e : wr) {

            }
        }
        return element;
    }

    private Element replaceDocumentValue(Element element,
                                         final String regEx,
                                         final String replace) {
        Elements children = element.children();
        String text = element.text();
        if (children.isEmpty() && Pattern.compile(regEx).matcher(text).find()) {
            element.text(text.replaceAll(regEx, replace));
        }
        return element;
    }
}
