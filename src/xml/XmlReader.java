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

/**
 * Maid to read from xml file
 */
public class XmlReader {
    /**
     * Method to read from xml
     *
     * @param xmlFileName path to xml file
     * @return list of beer objects
     * @see Beer
     */
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
                            switch (tName) {
                                case "beer": {
                                    beer = new Beer();
                                    beer.setIdentity(xmlStreamReader.getAttributeValue(null, "id"));
                                    break;
                                }
                                case "name": {
                                    beer.setName(xmlStreamReader.getElementText());
                                    break;
                                }
                                case "type": {
                                    beer.setBeerType(xmlStreamReader.getElementText());
                                    break;
                                }
                                case "alchoholType": {
                                    beer.setAlchoholType(xmlStreamReader.getElementText());
                                    break;
                                }
                                case "manufactor": {
                                    beer.setManufactor(xmlStreamReader.getElementText());
                                    break;
                                }
                                case "water": {
                                    Water water = new Water();
                                    water.setValue(xmlStreamReader.getElementText());
                                    beer.getIngridients().add(water);
                                    break;
                                }
                                case "malt": {
                                    Malt malt = new Malt();
                                    malt.setValue(xmlStreamReader.getElementText());
                                    beer.getIngridients().add(malt);
                                    break;
                                }
                                case "hop": {
                                    Hop hop = new Hop();
                                    hop.setValue(xmlStreamReader.getElementText());
                                    beer.getIngridients().add(hop);
                                    break;
                                }
                                case "sugar": {
                                    Sugar sugar = new Sugar();
                                    sugar.setValue(xmlStreamReader.getElementText());
                                    beer.getIngridients().add(sugar);
                                    break;
                                }
                                case "spiritAmount": {
                                    SpiritAmount spiritAmount = new SpiritAmount();
                                    spiritAmount.setValue(xmlStreamReader.getElementText());
                                    beer.getChars().add(spiritAmount);
                                    break;
                                }
                                case "filtration": {
                                    Filtration filtration = new Filtration();
                                    filtration.setValue(xmlStreamReader.getElementText());
                                    beer.getChars().add(filtration);
                                    break;
                                }
                                case "transparency": {
                                    Transparency transparency = new Transparency();
                                    transparency.setValue(xmlStreamReader.getElementText());
                                    beer.getChars().add(transparency);
                                    break;
                                }
                                case "nutritiveValue": {
                                    NutritiveValue nutritiveValue = new NutritiveValue();
                                    nutritiveValue.setValue(xmlStreamReader.getElementText());
                                    beer.getChars().add(nutritiveValue);
                                    break;
                                }
                                case "bottling": {
                                    Bottling bottling = new Bottling();
                                    bottling.setValue(xmlStreamReader.getElementText());
                                    beer.getChars().add(bottling);
                                    break;
                                }
                            }
                        }
                        case XMLStreamConstants.END_ELEMENT: {
                            String tName = xmlStreamReader.getLocalName();
                            if ("beer".equalsIgnoreCase(tName)) {
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
        } catch (XMLStreamException ex) {
            ex.getMessage();
            return null;
        } finally {
            try {
                xmlStreamReader.close();
            } catch (Exception e) {
            }
        }
    }
}
