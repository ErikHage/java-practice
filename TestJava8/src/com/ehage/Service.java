package com.ehage;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.StringReader;
import java.util.List;

/**
 *
 *
 * Created by Erik on 11/6/2016.
 */
public class Service {

    public static final String XPATH_TRADE_TYPE = "/trade/tradeType";

    public String getTradeLabel(String xml) throws Exception {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xml)));

        List<AbstractRule> ruleSet = getRules(document);

        ruleSet.forEach( rule -> {

        });

        return "";
    }

    public List<AbstractRule> getRules(Document document) throws Exception {

        String tradeType = getXpathValue(document, XPATH_TRADE_TYPE);


    }

    public String getXpathValue(Document document, String path) throws Exception {
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile(path);
        return (String)expr.evaluate(document, XPathConstants.STRING);
    }

}
