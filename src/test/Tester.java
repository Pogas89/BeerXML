package test;

import comporator.ComporatorByManufacture;
import domain.Beer;
import xml.XmlReader;
import xml.XmlValidator;

import java.util.Collections;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Beer bbb = new Beer();
        XmlValidator xmlValidator = new XmlValidator("beers.xml", "beers.xsd");
        if (xmlValidator.validate()) {
            XmlReader xmlReader = new XmlReader();
            List<Beer> beers = xmlReader.readXml("beers.xml");
            System.out.println("Sorted by Manufactor\n");
            Collections.sort(beers, new ComporatorByManufacture());
            for (Beer b:beers) {
                System.out.println(b);
            }
        } else {
            System.out.println(xmlValidator.getErrors());
        }
    }
}
