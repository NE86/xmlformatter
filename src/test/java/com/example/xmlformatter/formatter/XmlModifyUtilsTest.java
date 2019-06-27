package com.example.xmlformatter.formatter;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;

public class XmlModifyUtilsTest {

    private XmlModifyUtils xmlModifyUtilsTest = new XmlModifyUtils();

    private Element element, replaceElement;

    @Test
    public void replaceDocumentDate() {
        testDateText("word 12.09.2016 word", "word document_date word");
        testDateText("word ,12.09.2016", "word ,document_date");
        testDateText("word 30.30.2999 word", "word 30.30.2999 word");
        testDateText("word 12.09.2016 12.09.2016 12.09.2016 word", "word document_date document_date document_date word");
    }

    @Test
    public void replaceDocumentNumber() {
        testNumberText("word N 213213123 word", "word document_number word");
        testNumberText("word N 213213123", "word document_number");
        testNumberText("N СЛОВО-БУКВЫ-123 word", "document_number word");
        testNumberText("word N 213213123 N 213213123 word N 213213123  word",
            "word document_number document_number word document_number word");
    }

    @Test
    public void deleteRsid() {
        element = new Element("w:r");
        element.attributes().put(new Attribute("w:rsid",null));
        replaceElement = xmlModifyUtilsTest.deleteRsid(element);
        Assert.assertFalse(replaceElement.attributes().hasKey("w:rsid"));
    }

    private void testDateText(String text, String replaceText) {
        element = new Element("tag");
        element.text(text);
        replaceElement = xmlModifyUtilsTest.replaceDocumentDate(element);
        Assert.assertEquals(replaceElement.text(), replaceText);
    }

    private void testNumberText(String text, String replaceText) {
        element = new Element("tag");
        element.text(text);
        replaceElement = xmlModifyUtilsTest.replaceDocumentNumber(element);
        Assert.assertEquals(replaceElement.text(), replaceText);
    }
}
