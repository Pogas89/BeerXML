package xml;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ErrorHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Maid to validate xml file by xsd file
 */
public class XmlValidator extends DefaultHandler {
    private Boolean valid=true;
    private String xmlFileName;
    private String xsdFileName;
    List<Exception> exceptions = new ArrayList<>();

    /**
     *
     * @param xmlFileName path to xml file
     * @param xsdFileName path to xsd file
     */
    public XmlValidator(String xmlFileName, String xsdFileName) {
        this.xmlFileName = xmlFileName;
        this.xsdFileName = xsdFileName;
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        exceptions.add(e);
        valid=false;
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        exceptions.add(e);
        valid=false;
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        exceptions.add(e);
        valid=false;
    }

    public String getErrors() {
        if (!exceptions.isEmpty()) {
            return exceptions.toString();
        }
        return null;
    }

    /**
     * validate xml file by xsd file
     * @return boolean value of validation xml by xsd
     */
    public boolean validate() {
        try {
            Validator validator = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).
                    newSchema(new File(xsdFileName)).newValidator();
            validator.setErrorHandler(this);
            try {
                validator.validate(new StreamSource(xmlFileName));
            } catch (IOException e) {
                e.getMessage();
            }
            return valid;
        } catch (SAXException ex) {
            exceptions.add(ex);
            return false;
        }
    }
}
