package com.example.xmlformatter.formatter;

import org.jsoup.nodes.Element;

import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XmlElementAction extends RecursiveAction {

    private Element element;

    private Function<Element, Element> elementModify;

    public XmlElementAction(Element element, Function<Element, Element> elementModify) {
        this.element = element;
        this.elementModify = elementModify;
    }

    @Override
    protected void compute() {
        invokeAll(childElement());
    }

    private List<XmlElementAction> childElement() {
        return element.children()
            .stream()
            .map(elementModify)
            .map(element1 -> new XmlElementAction(element1, elementModify))
            .collect(Collectors.toList());
    }
}
