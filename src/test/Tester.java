package test;

import domain.Beer;
import xml.XmlReader;
import xml.XmlValidator;

import java.io.IOException;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        XmlValidator xmlValidator = new XmlValidator("beers.xml", "beers.xsd");
        if (xmlValidator.validate()) {
            XmlReader xmlReader = new XmlReader();
            List<Beer> beers = xmlReader.readXml("beers.xml");
            for (Beer b:beers) {
                System.out.println(b);
            }
        } else {
            System.out.println(xmlValidator.getError());
        }
    }
}
