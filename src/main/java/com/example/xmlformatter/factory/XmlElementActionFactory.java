package com.example.xmlformatter.factory;

import com.example.xmlformatter.formatter.XmlElementAction;
import com.example.xmlformatter.formatter.XmlModifyUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class XmlElementActionFactory {

    public static XmlElementAction getInstance(Document doc) {
        Element element = doc.children().get(0);
        XmlModifyUtils xmlModifyUtils = new XmlModifyUtils();
        return new XmlElementAction(element, (e) -> {
            e = xmlModifyUtils.replaceDocumentNumber(e);
            e = xmlModifyUtils.replaceDocumentDate(e);
            e = xmlModifyUtils.deleteRsid(e);

            return e;
        });
    }


}
