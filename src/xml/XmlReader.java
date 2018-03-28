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
            Ingridient ingridient = null;
            Chars chars = null;
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
                                case "ingridients":{
                                    ingridient=new Ingridient();
                                     break;
                                }
                                case "water": {
                                    Water water = new Water();
                                    water.setValue(Integer.valueOf(xmlStreamReader.getElementText()));
                                    ingridient.setWater(water);
                                    break;
                                }
                                case "malt": {
                                    Malt malt = new Malt();
                                    malt.setValue(Integer.valueOf(xmlStreamReader.getElementText()));
                                    ingridient.setMalt(malt);
                                    break;
                                }
                                case "Hop": {
                                    Hop hop = new Hop();
                                    hop.setValue(Integer.valueOf(xmlStreamReader.getElementText()));
                                    ingridient.setHop(hop);
                                    break;
                                }
                                case "sugar": {
                                    Sugar sugar = new Sugar();
                                    sugar.setValue(Integer.valueOf(xmlStreamReader.getElementText()));
                                    ingridient.setSugar(sugar);
                                    break;
                                }
                                case "chars":{
                                    chars = new Chars();
                                    break;
                                }
                                case "spiritAmount": {
                                    SpiritAmount spiritAmount = new SpiritAmount();
                                    spiritAmount.setValue(Double.valueOf(xmlStreamReader.getElementText()));
                                    chars.setSpiritAmount(spiritAmount);
                                    break;
                                }
                                case "filtration": {
                                    Filtration filtration = new Filtration();
                                    filtration.setFiltration(FiltrationType.valueOf(xmlStreamReader.getElementText()));
                                    chars.setFiltration(filtration);
                                    break;
                                }
                                case "transparency": {
                                    Transparency transparency = new Transparency();
                                    transparency.setValue(Integer.valueOf(xmlStreamReader.getElementText()));
                                    chars.setTransparency(transparency);
                                    break;
                                }
                                case "nutritiveValue": {
                                    NutritiveValue nutritiveValue = new NutritiveValue();
                                    nutritiveValue.setValue(Integer.valueOf(xmlStreamReader.getElementText()));
                                    chars.setNutritiveValue(nutritiveValue);
                                    break;
                                }
                                case "bottling": {
                                    Bottling bottling = new Bottling();
                                    bottling.setValue(xmlStreamReader.getElementText());
                                    chars.setBottling(bottling);
                                    break;
                                }
                            }
                            break;
                        }
                        case XMLStreamConstants.END_ELEMENT: {
                            String tName = xmlStreamReader.getLocalName();
                            switch (tName) {
                                case "beer": {
                                    beers.add(beer);
                                    break;
                                }
                                case "ingridients": {
                                    beer.setIngridients(ingridient);
                                    break;
                                }
                                case "chars":{
                                    beer.setChars(chars);
                                    break;
                                }
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
