package xml;

import domain.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlReader {
    public List<Beer> readXml(String xmlFileName) {
        XMLStreamReader xmlStreamReader = null;
        try {
            List<Beer> beers = new ArrayList<>();
            Beer beer = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            try {
                xmlStreamReader = factory.createXMLStreamReader(new FileInputStream(xmlFileName));
                while (xmlStreamReader.hasNext()) {
                    int elmType = xmlStreamReader.next();
                    switch (elmType) {
                        case XMLStreamConstants.START_ELEMENT: {
                            String tName = xmlStreamReader.getLocalName();
                            if ("beer".equalsIgnoreCase(tName)) {
                                beer = new Beer();
                                beer.setIdentity(xmlStreamReader.getAttributeValue(null, "id"));
                            } else if ("name".equalsIgnoreCase(tName)) {
                                beer.setName(xmlStreamReader.getElementText());
                            } else if ("type".equalsIgnoreCase(tName)) {
                                beer.setBeerType(xmlStreamReader.getElementText());
                            } else if ("alchoholType".equalsIgnoreCase(tName)) {
                                beer.setAlchoholType(xmlStreamReader.getElementText());
                            } else if ("manufactor".equalsIgnoreCase(tName)) {
                                beer.setManufactor(xmlStreamReader.getElementText());
                            } else if ("water".equalsIgnoreCase(tName)) {
                                Water water = new Water();
                                water.setValue(xmlStreamReader.getElementText());
                                beer.getIngridients().add(water);
                            } else if ("malt".equalsIgnoreCase(tName)) {
                                Malt malt = new Malt();
                                malt.setValue(xmlStreamReader.getElementText());
                                beer.getIngridients().add(malt);
                            } else if ("hop".equalsIgnoreCase(tName)) {
                                Hop hop = new Hop();
                                hop.setValue(xmlStreamReader.getElementText());
                                beer.getIngridients().add(hop);
                            } else if ("sugar".equalsIgnoreCase(tName)) {
                                Sugar sugar = new Sugar();
                                sugar.setValue(xmlStreamReader.getElementText());
                                beer.getIngridients().add(sugar);
                            } else if ("spiritAmount".equalsIgnoreCase(tName)) {
                                SpiritAmount spiritAmount = new SpiritAmount();
                                spiritAmount.setValue(xmlStreamReader.getElementText());
                                beer.getChars().add(spiritAmount);
                            } else if ("filtration".equalsIgnoreCase(tName)) {
                                Filtration filtration = new Filtration();
                                filtration.setValue(xmlStreamReader.getElementText());
                                beer.getChars().add(filtration);
                            } else if ("transparency".equalsIgnoreCase(tName)) {
                                Transparency transparency = new Transparency();
                                transparency.setValue(xmlStreamReader.getElementText());
                                beer.getChars().add(transparency);
                            } else if ("nutritiveValue".equalsIgnoreCase(tName)) {
                                NutritiveValue nutritiveValue = new NutritiveValue();
                                nutritiveValue.setValue(xmlStreamReader.getElementText());
                                beer.getChars().add(nutritiveValue);
                            } else if ("bottling".equalsIgnoreCase(tName)) {
                                Bottling bottling = new Bottling();
                                bottling.setValue(xmlStreamReader.getElementText());
                                beer.getChars().add(bottling);
                            }
                            break;
                        }
                        case XMLStreamConstants.END_ELEMENT: {
                            String tName = xmlStreamReader.getLocalName();
                            if ("beer".equalsIgnoreCase(tName)){
                                beers.add(beer);
                            }
                            break;
                        }
                    }
                }
                return beers;
            } catch (IOException e) {
                e.getMessage();
                return null;
            }
        }
        catch (XMLStreamException ex){
            ex.getMessage();
            return null;
        }
        finally {
            try {
                xmlStreamReader.close();
            } catch (Exception e){}
        }
    }
}
